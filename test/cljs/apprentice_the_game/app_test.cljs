(ns apprentice-the-game.app-test
  (:require-macros [cljs.test :refer [deftest testing is]])
  (:require [cljs.test :as t]
            [apprentice-the-game.app :as app]))

(deftest test-arithmetic []
  (is (= (+ 0.1 0.2) 0.3) "Something foul is a float."))
