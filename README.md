# Smart Converter

This is a project I did to learn and practice Java concepts. Here you will see concepts 
like the application of OOP, API consumption, JSON handling, custom exceptions, file 
generators, and more.

The application is a currency converter that runs in the console. You simply have to 
follow the instructions for use, and it will allow you to convert a value from one 
currency (e.g. USD) to the value of another currency (e.g. EUR). Additionally, it 
will save conversion records in a local file named "conversions.txt", which will reflect 
the value and currency to convert, the value and converted currency, and the time the 
conversion was made. In addition to this, an artificial progress bar has been added to 
enrich the experience of using Smart Converter.

This application is also a Challenge required to complete the [Oracle Next
Education (ONE)](https://www.oracle.com/co/education/oracle-for-education/#:~:text=Oracle%20Next%20Education,es%20100%25%20virtual%20y%20gratuito!)
program in collaboration with [Alura Latam](https://www.aluracursos.com/).

### API Key issue
If you go to the class ["HttpRequestHandler.java"](https://github.com/Juliobro/smart-converter/blob/main/src/com/juliobro/smartconverter/handlers/HttpRequestHandler.java), 
you will see that I am using an environment variable called API_KEY. I did this to 
protect my own API Key, not because I think it will be misused, but because I simply 
want to start adopting the good practice of protecting such data, which at certain 
times can be sensitive information.

To get your own API Key is very simple; you just need to go to [ExchangeRate-API](https://www.exchangerate-api.com/)
page and where it says "Get Free Key!" you should enter your email. Then simply follow
the instructions on the page, and you will have your own API Key in less than 2 minutes 
to try Smart Converter.

---

# Smart Converter

Este es un proyecto que realicé para aprender y practicar acerca de Java.
Aquí se verán conceptos como la aplicación de POO, consumo de API, manejo de JSON,
excepciones personalizadas, generadores de archivos y más.

La aplicación trata de un conversor de monedas que se ejecuta en consola,
simplemente debes seguir las instrucciones de uso y te permitirá convertir un valor
de cierta moneda (por ejemplo USD) al valor de otra moneda (como EUR) y, además,
guardará los registros de las conversiones en un archivo local llamado "conversiones.txt"
que reflejará el valor y moneda a convertir, el valor y moneda convertida y la hora en
que se realizó la conversión. Adicional a esto, se ha agregado una barra de progreso
artificial para enriquecer un poco la experiencia de utilizar Smart Converter.

Esta aplicación es también un Challenge requerido para finalizar el programa [Oracle Next
Education (ONE)](https://www.oracle.com/co/education/oracle-for-education/#:~:text=Oracle%20Next%20Education,es%20100%25%20virtual%20y%20gratuito!)
en colaboración con [Alura Latam](https://www.aluracursos.com/).

### Tema de la API Key
Si vas a la clase ["HttpRequestHandler.java"](https://github.com/Juliobro/smart-converter/blob/main/src/com/juliobro/smartconverter/handlers/HttpRequestHandler.java)
verás que estoy utilizando una variable de entorno llamada API_KEY. Esto lo hice
con la finalidad de proteger mi API Key propia, y no porque considere que se hará
mal uso de esta, sino porque simplemente quiero empezar a adoptar la buena práctica
de proteger ese tipo de datos que en ciertos momentos dados puede llegar a ser
información sensible.

Para conseguir tu propia API Key es muy sencillo; simplemente debes ir a la página
de [ExchangeRate-API](https://www.exchangerate-api.com/) y donde dice "Get Free Key!"
debes escribir tu correo electrónico. A continuación simplemente debes seguir las instrucciones
propuestas en la página y tendrás tu propia API Key en menos de 2 minutos para probar
Smart Converter.