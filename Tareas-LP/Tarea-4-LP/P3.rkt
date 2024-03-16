#lang scheme

; ; Esta funcion cuenta el largo de la lista
; ;
; ; lista : Lista la cual se quiere conocer su largo
(define (largo_lista lista)
  (if (null? lista)
      0
      (+ 1 (largo_lista (rest lista)))))

; ; Esta funcion verifica si se necesita comprar o no del ingrediente deseado
; ; Comparando la cantidad deseada, con los ingredientes que ya se tienen.
; ;
; ; cantidad : Cantidad del ingrediente deseado
; ; lista : Lista con los ingredientes que se tienen
(define (checkear cantidad lista)
  (define largo (largo_lista lista))
  (if (< largo cantidad)
      (- cantidad largo)
      0))

; ; Esta funcion, retorna el nombre del ingrediente a comprar, en caso de que se necesite
; ; Si no se necesita comprar, retorna una lista vacia
; ;
; ; lista_ingredientes : lista con la cantidad de los ingredientes deseados y los ingredientes que se tienen
(define (analisis_stock lista_ingredientes)
  (define nombre_ingredientes (rest lista_ingredientes))
  (define cant_comprar (checkear (first lista_ingredientes) (first nombre_ingredientes)))
  (if (= 0 cant_comprar)
      '()
      (list cant_comprar (first (first nombre_ingredientes)))))

(define (armar_lista stock)
  (if (null? stock)
      '()
      (let* ((ingredientes (first stock))
             (analisis (analisis_stock ingredientes))
             (resto (armar_lista (rest stock))))
        (if (not (null? analisis))
            (cons analisis resto)
            resto))))