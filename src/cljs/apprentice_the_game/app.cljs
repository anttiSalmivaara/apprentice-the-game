(ns apprentice-the-game.app
  (:require [reagent.core :as reagent]
            [reanimated.core :as anim]))

(def game-state (reagent/atom {:game-started  false,
                               :game-finished false,
                               :tiles-turned  0}))

(defn toggle-class [a k class1 class2]
      (.log js/console "click")
      (if (= (@a :tile-status) class1)
        (swap! a assoc :tile-status class2)
        (swap! a assoc :tile-status class1)))

(defn header-text []
      [:div.headertext
       [:h2 "apprentice-the-game"]
       [:p.headertext "the game that lets you smell the joy of clojure"]])

(defn header-image []
      [:img.mk3 {:src "mk3.jpg"}])

(defn tile-types []
      ["mk3.jpg" "intellij.jpeg" "docker.png" "slack.jpeg" "siili.png"
       "stack.png" "clojure.png" "gitlab.png"])

(defn random-tiles []
      (zipmap (range 1 17) (shuffle (concat (tile-types) (tile-types)))))

(defn game-tile [position tile]
      (let [possible-states (if (= tile "mk3.jpg")
                              ["tile-back" "tile-mk3"]
                              ["tile-back" "tile-front"])
            local-state (reagent/atom {:position    position,
                                       :tile        tile,
                                       :tile-status "tile-back"})]
           [:div {:class    (@local-state :tile-status)
                  :on-click #(toggle-class local-state :tile-status (first possible-states) (second possible-states))}
            [:img.tile (if (= "tile-back" (@local-state :tile-status))
                         {:src "mk3.jpg"}
                         {:src "tile"})]]))

(defn generate-game-tile [position tile]
      (.log js/console "generate-game-tile")
      [(keyword (str "div.position-" position)) (game-tile position tile)])

(defn game-board []
      (.log js/console "game-board")
      (vec (cons :div.board (map #(generate-game-tile (first %) (second %)) (random-tiles)))))

(defn generate-game-board []
      (if (not (@game-state :game-started))
        (do
          (swap! game-state :game-started true)
          (game-board))))



(defn generate-tiles []
      @(reagent/track (reagent/render-component [game-board] (.getElementById js/document "board"))))

(defn calling-component []
      (.log js/console "calling-component")
      [:div
       [header-image]
       [header-text]
       [generate-game-board]])

(defn init []
      (.log js/console "init")
      (reagent/render-component [calling-component]
                                (.getElementById js/document "container")))
