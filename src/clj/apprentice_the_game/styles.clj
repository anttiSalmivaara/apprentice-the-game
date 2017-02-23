(ns apprentice-the-game.styles
    (:require [garden.core :refer [css]]
      [garden.def :refer [defstyles]]
      [garden.stylesheet :refer [rule]]))

(defstyles screen
           [:body
            {:font-family      "'Arvo', serif",
             :font-size        "16px",
             :line-height      1.5,
             :background-color "#000000",
             :color            "#FFFFFF"}]
           [:div.headertext
            {:width            "40%",
             :margin-left      "auto",
             :margin-right     "auto",
             :background-color "#000000"}]
           [:div.board
            {:background-color "#111111",
             :width            "430px",
             :display          "block",
             :margin           "auto"}]
           ;[:div.tile
           ; {:-webkit-transition      "0.6s",
           ;  :-webkit-transform-style "preserve-3d",
           ;  :-moz-transition         "0.6s",
           ;  :-moz-transform-style    "preserve-3d",
           ;  :-o-transition           "0.6s",
           ;  :-o-transform-style      "preserve-3d",
           ;  :transition              "0.6s",
           ;  :transform-style         "preserve-3d"}]
           ;[:div.tile:flip .mk3-tile,
           ; :div.tile.flip .mk3-tile
           ; {:-ms-transform     "rotateY(180deg)",
           ;  :-moz-transform    "rotateY(180deg)",
           ;  :-webkit-transform "rotateY(180deg)",
           ;  :transform         "rotateY(180deg)"}]
           [:div.tile-front
            {:border-style                "solid",
             :vertical-align              "middle",
             :border-radius               "15px",
             :border-width                "2px",
             :border-color                "#999999",
             :width                       "100px",
             :height                      "100px",
             :text-align                  "center",
             :background-color            "#FFFFFF",
             :-webkit-backface-visibility "hidden",
             :-moz-backface-visibility    "hidden",
             :-o-backface-visibility      "hidden",
             :backface-visibility         "hidden"}]
           [:div.tile-back
            {:border-style                "solid",
             :vertical-align              "middle",
             :border-radius               "15px",
             :border-width                "2px",
             :border-color                "#999999",
             :width                       "100px",
             :height                      "100px",
             :text-align                  "center",
             :background-color            "#000000",
             :-webkit-backface-visibility "hidden",
             :-moz-backface-visibility    "hidden",
             :-o-backface-visibility      "hidden",
             :backface-visibility         "hidden"}]
           [:div.mk3-tile
            {:border-style                "solid",
             :vertical-align              "middle",
             :border-radius               "15px",
             :border-width                "2px",
             :border-color                "#999999",
             :width                       "100px",
             :height                      "100px",
             :text-align                  "center",
             :background-color            "#000000",
             :-webkit-backface-visibility "hidden",
             :-moz-backface-visibility    "hidden",
             :-o-backface-visibility      "hidden",
             :backface-visibility         "hidden"}]
           [:img.mk3
            {:display      "block",
             :margin-left  "auto",
             :margin-right "auto",
             :width        "200px",
             :height       "auto"}]
           [:img.tile
            {:width    "90px",
             :height   "auto",
             :position "absolute",
             :top      0,
             :bottom   0,
             :left     0,
             :right    0,
             :display  "block",
             :margin   "auto"}]
           [:h2
            {:color      "#999999",
             :text-align "center"}]
           [:p
            {:color "#8c8c8c"}]
           [:p.headertext
            {:text-align "center"}]
           [:div-position-1
            {:position   "absolute",
             :padding    "5px",
             :display    "block",
             :margin-top "10px"}]
           [:div-position-2
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "110px",
             :margin-top  "10px"}]
           [:div-position-3
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "220px",
             :margin-top  "10px"}]
           [:div-position-4
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "330px",
             :margin-top  "10px"}]
           [:div-position-5
            {:position   "absolute",
             :padding    "5px",
             :display    "block",
             :margin-top "120px"}]
           [:div-position-6
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "110px",
             :margin-top  "120px"}]
           [:div-position-7
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "220px",
             :margin-top  "120px"}]
           [:div-position-8
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "330px",
             :margin-top  "120px"}]
           [:div-position-9
            {:position   "absolute",
             :padding    "5px",
             :display    "block",
             :margin-top "230px"}]
           [:div-position-10
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "110px",
             :margin-top  "230px"}]
           [:div-position-11
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "220px",
             :margin-top  "230px"}]
           [:div-position-12
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "330px",
             :margin-top  "230px"}]
           [:div-position-13
            {:position   "absolute",
             :padding    "5px",
             :display    "block",
             :margin-top "340px"}]
           [:div-position-14
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "110px",
             :margin-top  "340px"}]
           [:div-position-15
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "220px",
             :margin-top  "340px"}]
           [:div-position-16
            {:position    "absolute",
             :padding     "5px",
             :display     "block",
             :margin-left "330px",
             :margin-top  "340px"}]
           :div-front)
