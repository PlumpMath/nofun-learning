(ns leiningen.new.nofun-learning
  (:require [leiningen.new.templates :refer [renderer year date project-name
                                             ->files sanitize-ns name-to-path
                                             sanitize multi-segment]]
            [leiningen.core.main :as main]))

(def render (renderer "nofun-learning"))

(defn nofun-learning
  "FIXME: write documentation"
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        unprefixed (if (.startsWith name "lein-")
                     (subs name 5)
                     name)
        
        data {:raw-name name
              :name (project-name name)
              :unprefixed-name unprefixed
              :namespace main-ns
              :sanitized (sanitize unprefixed)
              :nested-dirs (name-to-path main-ns)
              :year (year)
              :date (date)}]
    (main/info "Generating a project called " name " from the nofun-learning project template.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["doc/intro.md" (render "intro.md" data)]
             [".gitignore" (render "gitignore" data)]
             [".hgignore" (render "hgignore" data)]
             ["src/clj/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["src/cljs/{{sanitized}}/cards.cljs" (render "cards.cljs" data)]
             ["src/cljs/{{sanitized}}/config.cljs" (render "config.cljs" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["src/cljs/{{sanitized}}/db.cljs" (render "db.cljs" data)]
             ["src/cljs/{{sanitized}}/handlers.cljs" (render "handlers.cljs" data)]
             ["src/cljs/{{sanitized}}/subs.cljs" (render "subs.cljs" data)]
             ["src/cljs/{{sanitized}}/utils.cljs" (render "utils.cljs" data)]
             ["src/cljs/{{sanitized}}/views.cljs" (render "views.cljs" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ["resources/public/css/styles.css" (render "styles.css" data)]
             ["resources/public/index.html" (render "index.html" data)]
             "src/clj"
             "src/cljs"
             "resources/public/css")))
