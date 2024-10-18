Conversor de moneda
Presenta al usuario un grupo de códigos validos de moneda desde y hasta los cuales puede realizar conversiones. 

Con la siguiente estructura
Principal (Ejecutor. Define las Monedas habilitadas en el conversor. Se comunica con el usuario para saber sus requerimientos)
Consulta Currency (Realiza consulta a la API Exchange Rate obtiene la tasa de cambio)
Moneda a convertir (Define un Record que será el puente de comunicación entre el conversor y la API)
Convertidor (Realiza el  proceso de conversión y devuelve un resultado)

