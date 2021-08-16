(ns bienvenides.styles
  (:require [garden.core :as garden]
            [clojure.string :as string]
            [bienvenides.views :as views]))

(def STYLE_ID "bienvenides-style")

(def css-rules
  (concat
   [[:h1 {:font-size "1.5rem"
          :font-family "Bitter ,\"Noto Serif SC\" ,serif"
          :letter-spacing 0
          :font-weight 700
          :line-height 1.2
          :word-break "break-word"}]

    [:h2 {:display "block"
          :font-size "1.5em"
          :margin-block-start "0.83em"
          :margin-block-end "0.83em"
          :margin-inline-start "0px"
          :margin-inline-end "0px"
          :font-weight "bold"}]
   
    [:body {}]

    [:html {:font-size "100%"}]

    ["#app" {:position "relative"}]]

   views/main-panel-styles))

(defn inject-styles! []
  (let [tag (js/document.getElementById STYLE_ID)
        styles (->> css-rules
                    (map garden/css)
                    (string/join "\n"))]
    (set! (.. tag -innerHTML) styles)))
