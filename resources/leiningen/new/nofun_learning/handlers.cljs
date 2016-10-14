(ns {{name}}.handlers
    (:require [re-frame.core :as re-frame]
              [{{name}}.db :as db]
              [{{name}}.cards :as cards]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
