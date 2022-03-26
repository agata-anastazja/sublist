(ns sublist)


(defn isSublist? [l1 l2]
  (let [first-element-to-find (first l1)
        length-of-l1 (count l1)
        index-of-start-of-match (.indexOf l2 first-element-to-find)
        first-element-present (>= index-of-start-of-match 0)
        potential-match (subvec l2 index-of-start-of-match)
        l2-long-enough-to-contain-match (>= (count potential-match) length-of-l1)]
    (when (and first-element-present l2-long-enough-to-contain-match)
      (let [potential-match-2 (subvec l2 index-of-start-of-match (+ index-of-start-of-match length-of-l1))]
        (= potential-match-2 l1)))))

(defn isSuperlist [l1 l2] true)

(defn classify [list1 list2] ;; <- arglist goes here
      ;; your code goes here
  (cond
    (= list1 list2) :equal
    (= (count list1) (count list2)) :unequal
    (and (< (count list1) (count list2)) (isSublist? list1 list2)) :sublist
    (and (> (count list1) (count list2)) (isSuperlist list1 list2)) :superlist))

(comment
  (classify [] [1 2 3])
  (.indexOf  [1 2 2] 2)
  (set (concat [] [1 2 3]))
  (subvec [1] (.indexOf [1] 1) (count [1]))
  (isSublist? [2 3] [1 2 4 2 3])
  (= [1] [1])

  (subvec [1 2] 1 2)

  (def l1 [2])
  (def l2  [1 2])
  (def first-element-to-find (first l1))
  (def length-of-l1 (count l1))
  (def  index-of-start-of-match (.indexOf l2 first-element-to-find))
  index-of-start-of-match
  (def first-element-present (>= index-of-start-of-match 0))
  first-element-present
  (def l2-long-enough-to-contain-match (>= (count (subvec l2 index-of-start-of-match)) length-of-l1))
  l2-long-enough-to-contain-match
  )
