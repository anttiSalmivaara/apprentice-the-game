(ns apprentice-the-game.app
  (:require [reagent.core :as reagent]
            [reanimated.core :as anim]))

(def game-state (reagent/atom {:game-started  false,
                               :pairs-found   0,
                               :tiles-flipped 0,
                               :flipped-1-position 0,
                               :flipped-2-position 0}))

(defn state-update [position]
  (let [amount-flipped (@game-state :tiles-flipped)
        one-flipped (@game-state :flipped-1-position)]
    (cond
      (= 0 amount-flipped) (swap! game-state assoc (keyword (str "position-" position "-flipped")) true
                                                   :flipped-1-position position
                                                   :tiles-flipped 1)
      (and (= 1 amount-flipped) (not (= position one-flipped))) (swap! game-state assoc (keyword (str "position-" position "-flipped")) true
                                                                                        :flipped-2-position position
                                                                                        :tiles-flipped 2))))


(defn header-text []
      [:div.headertext
       [:h2 "apprentice-the-game"]
       [:p.headertext "the game that lets you experience the joy of clojure"]])

(defn header-image []
      [:img.mk3 {:src "mk3.jpg"}])

(defn tile-types []
      ["cljs.png" "intellij.jpeg" "heroku.png" "slack.jpeg" "siili.png"
       "stack.png" "clojure.png" "gitlab.png"])

(defn random-tiles []
      (let [tiles (zipmap (range 1 17) (shuffle (concat (tile-types) (tile-types))))]
           (doall (map #(swap! game-state assoc (keyword (str "position-" (first %) "-img")) (second %)) tiles))))

(defn game-tile [position]
      (let [flipped? (@game-state (keyword (str "position-" position "-flipped")))
            tile-image (@game-state (keyword (str "position-" position "-img")))]
           [:div {:class    (if flipped?
                              "tile-front"
                              "tile-back")
                  :on-click #(state-update position)}
            [:img.tile (if flipped?
                         {:src tile-image}
                         {:src "mk3.jpg"})]]))

(defn generate-game-tile [position]
      [(keyword (str "div.position-" position)) (game-tile position)])

(defn game-view []
      (vec (cons :div (map #(generate-game-tile %) (range 1 17)))))

(defn end-view []
      [:div.end
       [:img.blown {:src "blown.gif"}]])

(declare game-board)

(defn two-tiles-flipped []
  (let [flipped-1-position (@game-state :flipped-1-position)
        flipped-2-position (@game-state :flipped-2-position)
        flipped-1-tile (@game-state (keyword (str "position-" flipped-1-position "-img")))
        flipped-2-tile (@game-state (keyword (str "position-" flipped-2-position "-img")))]
    (do
      (.log js/console (str flipped-1-position " " flipped-2-position " " flipped-1-tile " " flipped-2-tile))
      (if (not (= flipped-1-tile flipped-2-tile))
        (swap! game-state assoc (keyword (str "position-" flipped-1-position "-flipped")) false
                                (keyword (str "position-" flipped-2-position "-flipped")) false)
        (swap! game-state assoc :pairs-found (inc (@game-state :pairs-found))))
      (swap! game-state assoc :tiles-flipped 0
                              :flipped-1-position 0
                              :flipped-2-position 0)
      (game-board))))


(defn start-game []
      (do
        (swap! game-state assoc :game-started true)
        (map #(swap! game-state assoc (keyword (str "position-" (first %) "-flipped")) false) (range 1 17))
        (random-tiles)))

(defn start-view []
      [:div.start {:on-click #(start-game)}
       [:h2.start "START"]])


(defn game-board []
      [:div.board
       (cond
         (not (@game-state :game-started)) (start-view)
         (= 8 (@game-state :pairs-found)) (end-view)
         (= 2 (@game-state :tiles-flipped)) (two-tiles-flipped)
         :else (game-view))])

(defn calling-component []
      [:div
       [header-image]
       [header-text]
       [game-board]])

(defn init []
      (reagent/render-component [calling-component]
                                (.getElementById js/document "container")))
