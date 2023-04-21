# Ejemplo 4 - Servicio base y carga de datos al inicializar el proyecto

## Servicio Base

En una primera aproximación arquitectónica de una aplicación web, una buena práctica para evitar el acoplamiento es no utilizar los repositorios directamente desde los controladores. En su lugar, podemos implementar una capa de servicios que capture toda la lógica de negocio.

Los métodos CRUD (inserción de una nueva entidad, edición de una existente, borrado de una entidad, búsqueda de una entidad por su Id y la búsqueda de todas las entidades de un tipo) suelen ser muy repetitivos de implementar. **De hecho, su codificación en el servicio es simplemente un envoltorio de los métodos correspondientes en el repositorio**.

Por eso, es sensato proporcionar una implementación base de un servicio abstracto, que nos proporcione esta implementación, y nos permita centrarnos solo en nuestra lógica de negocio.

### Ejemplo de servicio base

Primero, podemos implementar una interfaz genérica que defina los métodos que vamos a incluir:

```java
public interface BaseService<T, ID> {
	
	List<T> findAll();
	
	Optional<T> findById(ID id);
	
	T save(T t);
	
	T edit(T t);
	
	void delete(T t);
	
	void deleteById(ID id);
	

}
```

Y una clase abstracta que la implemente:

```java
public abstract class 
		BaseServiceImpl<T, ID, R extends JpaRepository<T, ID>> 
		implements BaseService<T, ID> {

	@Autowired
	protected R repository;
	
	
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

	@Override
	public T save(T t) {
		return repository.save(t);
	}

	@Override
	public T edit(T t) {
		return repository.save(t);
	}

	@Override
	public void delete(T t) {
		repository.delete(t);
		
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);		
	}
	
}

```

Utilizamos _genéricos_ para establecer los tipos de datos que necesitamos:

- `T`, el tipo de entidad que vamos a gestionar.
- `ID`, el tipo de dato su de Id (_clave primaria_).
- `R`, el tipo de dato de su repositorio (por ello utilizamos un parámetro de _tipo delimitado_).

### Creación de un nuevo servicio a partir del servicio base

La creación de un nuevo servicio a partir de este es ya muy sencilla

```java
@Service
public class AlumnoServicio
	extends BaseServiceImpl<Alumno, Long, AlumnoRepositorio>{
		
	
}
```

> Si de verdad queremos mejorar esta solución, tendríamos que definir cada uno de estos servicios en una **interfaz** y una **implementación**. Con esto, también ganaríamos en desacoplar nuestros servicios del resto de capas, como los controladores.

### Limitaciones de esta solución

Una de las limitaciones que tiene es fácilmente subsanable. Se podría dar el caso de que el tipo `T` no fuese una entidad de nuestro modelo. Para solucionarlo, podríamos _forzar_ a que todas nuestras clases modelo implementaran una interfaz, y utilizar dicha interfaz para delimitar el tipo del parámetro `T`.

## Importación de datos

Hasta ahora, para tener algunos datos iniciales en nuestros proyectos, hemos creado un bean (a veces llamado `MainDeMentira`) en el cual hemos inyectado o bien repositorios, o bien servicios, y a través del cual hemos hecho las inserciones.

Hiberante nos ofrece un mecanismo más apropiado para realizarlo a través de un fichero SQL. Este fichero:

- Debe almacenarse en la ruta `src/main/resources/` o en una subcarpeta de esa ruta
- Debe llamarse `import.sql`.

Por defecto, si en la carga del proyecto se detecta que existe ese fichero, se ejecutará tras haber realizado las operaciones de DDL (si la propiedad `spring.jpa.hibernate.ddl-auto` tiene algún valor que indique que se tiene que crear o actualizar el esquema de la base de datos).

Las operaciones que se realizan en este fichero deben ser sentencias SQL, tales como `INSERT INTO...`, `UPDATE...` o alguna sentencia complementaria que cree, altere o modifique algún elemento de la base de datos.

> Spring Data JPA ofrece otro mecanismo complementario, que también utiliza SQL, a través de dos ficheros: uno llamado `schema.sql` y otro llamado `data.sql`. Este mecanismo permite crear diferentes ficheros asociados a distintos perfiles de ejecución. Si quieres tener más información de cómo usarlo puedes consultar [aquí](https://www.baeldung.com/spring-boot-data-sql-and-schema-sql#thedatasqlfile).

