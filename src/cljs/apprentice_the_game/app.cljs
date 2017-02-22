(ns apprentice-the-game.app
  (:require [reagent.core :as reagent]))

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
      (zipmap (range 16) (shuffle (concat (tile-types) (tile-types)))))

(defn game-tile [tile-content]
      [(if (= tile-content "mk3.jpg")
            :div.mk3-tile
            :div.tile)
       [:img.tile {:src tile-content}]])

(defn generate-game-tile [position tile]
      [(keyword (str "div-position-" (inc position))) (game-tile tile)])

(defn game-board []
      (vec (cons :div.board (map #(generate-game-tile (first %) (second %)) (random-tiles)))))

(defn calling-component []
      [:div
       [header-image]
       [header-text]
       [game-board]])

(defn init []
      (reagent/render-component [calling-component]
                                (.getElementById js/document "container")))
