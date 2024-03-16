#lang scheme

; ; Esta funcion cuenta el largo de la lista
; ;
; ; lista : Lista la cual se quiere conocer su largo
(define (largo_lista lista)
  (if (null? lista)
      0
      (+ 1 (largo_lista (rest lista)))))


(define (checkear cantidad lista)
  (define largo (largo_lista lista))
  (if (= largo cantidad) "true" "false"))