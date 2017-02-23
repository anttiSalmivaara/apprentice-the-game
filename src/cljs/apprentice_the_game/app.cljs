(ns apprentice-the-game.app
  (:require [reagent.core :as reagent]
            [reanimated.core :as anim]))

(defn toggle-class [a k class1 class2]
      (if (= (:status @a) class1)
        (swap! a assoc :status class2 :passive-status class1)
        (swap! a assoc :status class1 :passive-status class2)))

(defonce state {:position1  (reagent/atom {}),
                :position2  (reagent/atom {}),
                :position3  (reagent/atom {}),
                :position4  (reagent/atom {}),
                :position5  (reagent/atom {}),
                :position6  (reagent/atom {}),
                :position7  (reagent/atom {}),
                :position8  (reagent/atom {}),
                :position9  (reagent/atom {}),
                :position10 (reagent/atom {}),
                :position11 (reagent/atom {}),
                :position12 (reagent/atom {}),
                :position13 (reagent/atom {}),
                :position14 (reagent/atom {}),
                :position15 (reagent/atom {}),
                :position16 (reagent/atom {})})

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

(defn game-tile [position tile-atom]
      [:div {:class    (:status @tile-atom)
             :on-click #(toggle-class tile-atom :status)}
       [:img.tile (if (= "tile.back" (first (@state position)))
                    {:src "mk3.jpg"}
                    {:src (nth (@state position) 1)})]])

(defn generate-game-tile [position tile]
      (swap! ((keyword (str "position" position)) state) assoc :status "tile-back")
      (swap! ((keyword (str "position" position)) state) assoc :tile "tile")
      (swap! ((keyword (str "position" position)) state) assoc :passive-status (if (= tile "mk3.jpg")
                                                                                 "mk3-tile"
                                                                                 "tile-front"))
      [(keyword (str "div-position-" position)) (game-tile position ((keyword (str "position" position)) state))])

(defn game-board []
      (vec (cons :div.board (map #(generate-game-tile (first %) (second %)) (random-tiles)))))

(defn calling-component []
      (.log js/console "calling-component")
      [:div
       [header-image]
       [header-text]
       [game-board]])

(defn init []
      (.log js/console "init")
      (reagent/render-component [calling-component]
                                (.getElementById js/document "container")))
