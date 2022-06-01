# Alkemy® Parking
## Ejercicio integrador de Kotlin
#### Estructura
- VehicleType:
  * Enum con los tipos de vehículo y su costo individual por hora

- Vehicle:
  * Crea la lista de vehículos individuales agregados
  * Método para verificar que cada vehículo agregado sea único

- Parking:
  * Creación del Set de vehículos
  * Métodos principales
    - Agregar vehículos
    - Buscar vehículos
    - Quitar vehículos
    - Imprimir vehículos que se retiran
    - Listar vehículos estacionados
  * Capacidad total del estacionamiento

- ParkingSpace: hereda de Parking
  * Métodos de cálculo:
    - Calcular importe total
      * Verificación de tarjeta de descuento
    - Calcular importe individual por vehiculo
      * TODO: posibilidad de usar `ceil`
  * Mostrar si acaso funciona
  * Mostrar si NO funciona

- Main:
  * 20 ejemplos funcionales
  * 2 ejemplos fallidos
  * Cálculo de importe total
  * Lista de patentes de vehículos estacionados
