(ns {{name}}.views
  (:require [{{name}}.utils :refer [state-viewer]]
            [re-frame.core :as re-frame]
            [{{name}}.cards :as cards]))

(defn main-panel []
  [:div
   [:h1 "Welcome to the world's first New Orleans Clojure Workshop!"]
   [:img {:src "/louisarmstrong.jpg"}]])
