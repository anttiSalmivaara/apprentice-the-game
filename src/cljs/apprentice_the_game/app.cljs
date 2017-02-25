(ns apprentice-the-game.app
  (:require [reagent.core :as reagent]
            [reanimated.core :as anim]))

(def game-state (reagent/atom {:game-started  false,
                               :game-finished false,
                               :pairs-found 0}))

(defn header-text []
      [:div.headertext
       [:h2 "apprentice-the-game"]
       [:p.headertext "the game that lets you smell the joy of clojure"]])

(defn header-image []
      [:img.mk3 {:src "mk3.jpg"}])

(defn tile-types []
      ["cljs.png" "intellij.jpeg" "docker.png" "slack.jpeg" "siili.png"
       "stack.png" "clojure.png" "gitlab.png"])

(defn random-tiles []
  (let [tiles (zipmap (range 1 17) (shuffle (concat (tile-types) (tile-types))))]
    (doall (map #(swap! game-state assoc (keyword (str "position" (first %) "img")) (second %)) tiles))))

(defn game-tile [position]
      (let [position-flipped (keyword (str "position-" position "-flipped"))
            flipped? (@game-state position-flipped)
            tile-image (@game-state (keyword (str "position" position "img")))]
        [:div {:class (if flipped?
                        "tile-front"
                        "tile-back")
               :on-click #(swap! game-state assoc position-flipped (not flipped?))}
         [:img.tile (if flipped?
                      {:src tile-image}
                      {:src "mk3.jpg"})]]))

(defn generate-game-tile [position]
      [(keyword (str "div.position-" position)) (game-tile position)])

(defn game-view []
   (vec (cons :div (map #(generate-game-tile %) (range 1 17)))))

(defn start-game []
  (do
    (swap! game-state assoc :game-started true)
    (map #(swap! game-state assoc (keyword (str "position-" (first %) "-flipped")) false) (range 1 17))
    (random-tiles)))

(defn start-view []
  [:div.start {:on-click #(start-game)}
   [:h2.start "START"]])

(defn end-view []
  [:div.end
   [:img.blown {:src "blown.gif"}]])

(defn game-board []
  [:div.board
      (cond
        (@game-state :game-finished) (end-view)
        (not (@game-state :game-started)) (start-view)
        :else (game-view))])


(defn calling-component []
      [:div
       [header-image]
       [header-text]
       [game-board]])

(defn init []
      (reagent/render-component [calling-component]
                                (.getElementById js/document "container")))
