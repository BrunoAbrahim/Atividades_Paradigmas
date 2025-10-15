(ns atividades.sistemanotas
  (:gen-class))

(def limite-a 90)
(def limite-b 80)
(def limite-c 70)
(def limite-d 60)

(defn classificar-nota [nota]
  (cond
    (>= nota limite-a) "A"
    (>= nota limite-b) "B"
    (>= nota limite-c) "C"
    (>= nota limite-d) "D"
    :else "F"))

(defn -main []
  (println "Quantos alunos tem na turma?")
  (let [qtd (Integer/parseInt (read-line))]
    (loop [i 1
           soma 0
           aprovados 0]
      (if (> i qtd)
        (do
          (println "Media da turma:" (/ soma qtd))
          (println "Taxa de aprovacao:" (* 100 (/ aprovados qtd)) "%"))
        (do
          (println (str "Nota do aluno " i ":"))
          (let [nota (Double/parseDouble (read-line))
                conceito (classificar-nota nota)]
            (println "Conceito:" conceito)
            (recur (inc i)
                   (+ soma nota)
                   (if (not= conceito "F") (inc aprovados) aprovados))))))))
