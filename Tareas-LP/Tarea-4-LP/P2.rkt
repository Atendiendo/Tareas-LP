#lang scheme

(define (cantidades_simple base lista)
  (if (null? lista)
      '()
      (cons ((lambda (f) (f base)) (first lista)) (cantidades_simple base (rest lista)))))

(define (cantidades_cola base lista)
  (let desarrollo((funciones lista) (resultado '()))
    (if (null? funciones)
        (reverse resultado)
        (desarrollo (rest funciones) (cons ((lambda (f) (f base)) (first funciones)) resultado)))))