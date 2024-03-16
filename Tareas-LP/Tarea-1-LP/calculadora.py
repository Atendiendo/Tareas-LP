import re

def cupon(num1):
    '''
    ***
    * num1 : Entero
    ***
    Retorna el 20% de un numero truncado.
    '''
    resultado = int(0.2*num1)
    return resultado

def cupon_especifico(num1,num2):
    '''
    ***
    * num1 : Entero
    * num2 : Entero
    ***
    Retorna un descuento específico basado en un porcentaje dado no mayor a 100.
    '''
    num2 = num2/100
    resultado = int(num1*num2)
    return resultado

def div_mult(operacion,ans):
    '''
    ***
    * operacion : String
    * ans : Entero
    ***
    Realiza operaciones de multiplicación y división en una cadena de operaciones.
    Reemplaza las ocurrencias de 'ANS' con el valor correspondiente.
    Retorna la cadena de operaciones con los resultados calculados.
    '''
    patron = r'\s*(\d+|ANS)\s*(\*|//)\s*(\d+|ANS)\s*'
    match = re.search(patron, operacion)

    while match:

        num1 = match.group(1)
        operador = match.group(2)
        num2 = match.group(3)

        if num1 == "ANS":
            num1=ans
        if num2 == "ANS":
            num2 = ans


        if operador == '*':
            result = int(num1) * int(num2)
            if result < 0:
                result = 0
        elif operador == '//':
            result = int(num1) // int(num2)
            if result < 0:
                result = 0
        

        operacion = operacion.replace(match.group(), str(result))
        match = re.search(patron, operacion)

    return operacion

def sum_rest(operacion,ans):
    '''
    ***
    * operacion : String
    * ans : Entero
    ***
    Realiza operaciones de suma y resta en una cadena de operaciones.
    Reemplaza las ocurrencias de 'ANS' con el valor correspondiente.
    Retorna la cadena de operaciones con los resultados calculados.
    '''
    patron = r'\s*(\d+|ANS)\s*(-|\+)\s*(\d+|ANS)\s*'
    match = re.search(patron, operacion)

    while match:

        num1 = match.group(1)
        operador = match.group(2)
        num2 = match.group(3)


        if num1 == "ANS":
            num1=ans
        if num2 == "ANS":
            num2 = ans


        if operador == '+':
            result = int(num1) + int(num2)
            if result < 0:
                result = 0
        elif operador == '-':
            result = int(num1) - int(num2)
            if result < 0:
                result = 0
        

        operacion = operacion.replace(match.group(), str(result))
        match = re.search(patron, operacion)

    return operacion

def desarrollo_cupones(expresion,ans):
    '''
    ***
    * expresion : String
    * ans : Entero
    ***
    Realiza el desarrollo de cupones en una expresión.
    Reemplaza las ocurrencias de 'CUPON(...)' con los resultados calculados.
    Retorna la expresión con los cupones desarrollados.
    '''
    patron = r'CUPON\((\s*(?:\d+|ANS)(?:\s*,\s*(?:\d+|ANS))?\s*)*\)'
    match = re.search(patron,expresion)

    while match:
        
        parametros = re.findall(r'\d+|ANS', match.group(1))

        if len(parametros) == 1:
            if parametros[0] == "ANS":
                result = cupon(ans)
            else:
                result = cupon(int(parametros[0]))
        else:
            if parametros[0] == "ANS" and parametros[1] == "ANS":
                result = cupon_especifico(ans,ans)
            elif parametros[0] == "ANS":
                result = cupon_especifico(ans,int(parametros[1]))
            elif parametros[1] == "ANS":
                result = cupon_especifico(int(parametros[0]),ans)
            else:
                result = cupon_especifico(int(parametros[0]),int(parametros[1]))

        
        expresion = expresion.replace(match.group(), str(result)) 
        match = re.search(patron, expresion)


    return expresion

def desarrollo(expresion,ans):
    '''
    ***
    * expresion : String
    * ans : Entero
    ***
    Realiza el desarrollo completo de una expresión.
    Reemplaza las ocurrencias de 'CUPON(...)' con los resultados calculados.
    Resuelve los paréntesis y luego realiza operaciones de multiplicación/división y suma/resta en la expresión.
    Retorna el resultado final.
    '''
    expresion = desarrollo_cupones(expresion,ans)

    expresion = resolver_parentesis(expresion, ans)

    result = div_mult(expresion,ans)

    result = sum_rest(result,ans)

    return result

def resolver_parentesis(expresion, ans):
    '''
    ***
    * expresion : String
    * ans : Entero
    ***
    Resuelve los paréntesis en una expresión matemática.
    Evalúa el contenido dentro de los paréntesis utilizando la función 'desarrollo'.
    Retorna la expresión con los paréntesis resueltos.
    '''
    while '(' in expresion:
        match = re.search(r'\(([^()]*)\)', expresion)
        if match:
            expresion_interna = match.group(1)
            resultado_interno = desarrollo(expresion_interna, ans)
            expresion = expresion.replace(match.group(), str(resultado_interno))

    return expresion

def main_deteccion_errores(expresion,ans):
    '''
    ***
    * expresion : String
    * ans : Entero
    ***
    Realiza la detección de errores en una expresión matemática.
    Retorna True si se detecta algún error, de lo contrario, retorna False.
    '''
    existe_error = False

    expresion = expresion.replace("ANS",str(ans)+" ")

    patron = r'^CUPON\(\s*\d+(?:\s*,\s*\d+)*\)$'
    match = re.search(patron, expresion)

    if match:
        existe_error = True
        return existe_error
    

    patron = r'CUPON\(CUPON|CUPON\((\d+),CUPON\('
    match = re.search(patron, expresion)

    if match:
        existe_error = True
        return existe_error


    patron = r'CUPON\(\s*(?:\d+)(?:\s*,\s*(?:\d+)?\s*)*\)'
    match = re.search(patron, expresion)

    while match:
        expresion = expresion.replace(match.group(), "1 ") 
        match = re.search(patron, expresion)
    

    patron = r'[^+\-*//()\d\s]'
    match = re.search(patron, expresion)

    if match:
        existe_error = True
        return existe_error
    

    if error_parentesis(expresion):
        existe_error = True
        return existe_error
    

    patron = r'\(([^()]*)\)' 
    matches = re.search(patron,expresion)

    if matches == None:
        existe_error = deteccion_errores(expresion)

    while matches:
        error = deteccion_errores(matches.group(1))
        if error:
            existe_error = True
            return existe_error

        expresion = expresion.replace(matches.group(), "1")
        matches = re.search(patron,expresion)
        if error_parentesis(expresion):
            existe_error = True
            return existe_error
        

    return existe_error

def deteccion_errores(expresion):
    '''
    ***
    * expresion : String
    * ans : Entero
    ***
    Se asegura que no hayan divisiones por cero y que todas las operaciones aritmeticas
    Tengan al menos 2 digitos y un operador
    Retorna True si se detecta algún error, de lo contrario, retorna False.
    '''
    hay_error = False
    patron = r'(\d+)?\s*(\*|//|-|\+)?\s*(\d+)?'
    match = re.search(patron, expresion)


    while match and expresion != '1':

        num1 = match.group(1)
        operador = match.group(2)
        num2 = match.group(3)

        if operador == None:
            hay_error = True
            return hay_error

        if num1 == None or num2 == None:
            hay_error = True
            return hay_error
        
        if operador == "//" and num2 == "0":
            hay_error = True
            return hay_error
        

        expresion = expresion.replace(match.group(), "1")
        match = re.search(patron, expresion)


    return hay_error

def conteo_parentesis(expresion):
    '''
    ***
    * expresion : String
    ***
    Realiza el conteo de paréntesis en una expresión y determina si están balanceados.
    Retorna True si los paréntesis están balanceados, de lo contrario, retorna False.
    '''
    contador = 0
    for caracter in expresion:
        if caracter == '(':
            contador += 1
        elif caracter == ')':
            contador -= 1
    
    if contador == 0:
        balanceado = True
    else:
        balanceado = False

    return balanceado

def error_parentesis(expresion):
    '''
    ***
    * expresion : str
    ***
    Verifica que no haya solo una cosa dentro de un parentesis.
    Retorna True si se encuentra un error, de lo contrario, retorna False.
    '''
    patron = r'\((\*|//|-|\+|\d+|ANS|CUPON\(\s*\d+(?:\s*,\s*\d+)*\))\)'
    match = re.search(patron,expresion)
    if match:
        return True
    else:
        return False

def escribir(nombre_arch,lista_operaciones,resultado):
    '''
    *** 
    * nombre_arch : String
    * lista_operaciones : Lista
    * resultado : Lista
    ***
    Escribe los resultados de las operaciones en un archivo.
    '''
    with open(nombre_arch,'a') as f:
        i = 0
        while i < len(lista_operaciones):
            f.write(str(lista_operaciones[i])+' '+'='+' '+ str(resultado[i]) +'\n')
            i += 1
        f.write('\n')

def main(arch_problemas,arch_desarrollos):
    '''
    ***
    * arch_problemas : String
    * arch_desarrollos : String
    ***
    Realiza el procesamiento principal de la resolución de problemas y escribe los resultados en un archivo.
    '''
    ans = 0
    operaciones = []
    resultados_list = []
    errores_list = []
    with open(arch_problemas, "r") as f:

        texto_completo = f.readlines()
        lineas_totales = len(texto_completo)

        lineas_leidas = 0
        for linea in texto_completo:

            lineas_leidas += 1
            linea = linea.strip()

            if (linea != ''):
                operaciones.append(linea)

            if (linea == '') or (lineas_leidas == lineas_totales):

                error_linea = False
                error_bloque = False

                i = 0
                while i < len(operaciones):

                    error_linea = main_deteccion_errores(operaciones[i], ans)

                    if not error_bloque:
                        error_bloque = error_linea
                        if not error_linea:
                            ans = desarrollo(operaciones[i],int(ans))
                    
                    i += 1

                i = 0
                while i < len(operaciones) and error_bloque:
                    ans = 0

                    error_linea = main_deteccion_errores(operaciones[i], ans)

                    if error_linea:
                        errores_list.append("Error")

                    else:
                        errores_list.append("Sin resolver")
                    
                    i += 1

                    

                i = 0
                ans = 0
                while i < len(operaciones) and not error_bloque:

                    resultado = desarrollo(operaciones[i],int(ans))
                    ans = resultado
                    resultados_list.append(resultado)

                    i += 1


                if not error_bloque:
                    escribir(arch_desarrollos,operaciones,resultados_list)
                else:
                    escribir(arch_desarrollos,operaciones,errores_list)


                ans = 0
                operaciones.clear()
                resultados_list.clear()
                errores_list.clear()

if __name__ == "__main__":
    main('problemas.txt','desarrollos.txt')