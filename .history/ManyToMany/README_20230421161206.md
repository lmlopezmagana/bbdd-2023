
# Ejemplo 5 - Ejemplo una asociación _Many To Many_ (bidireccional)

Partimos desde el ejemplo [one-to-many](../ManyToOne/)

## ¿Cuál es nuestro modelo de datos?

![diagrama uml](./uml.jpg) 

## Algo de teoría sobre asociaciones _ManyToMany_

Una asociación _muchos-a-muchos_ es un tipo de _relación_ entre clases, por la cual, una instancia de uno de los tipos conectados, se puede asociar a muchas instancias del otro tipo, y viceversa. Uno de los ejemplos clásicos suele ser el de las clases `Autor` y `Libro`, mediante la cual un `Autor` puede escribir muchos `Libro`, y un `Libro` puede ser escrito por muchos autores. 

Aunque esta asociación tenga la misma _multiplicidad_ en ambos extremos, también puede tratarse de forma bien **unidireccional**, bien **bidireccional**. Escoger una u otra queda a cargo del programador.

JPA nos ofrece una anotación parecida a las anteriores, `@ManyToMany`, que nos permitirá manejar la relación. En este caso, dicha anotación irá asociada a una colección (normalmente, un `Set` o un `List`).

```java
@ManyToMany
List<Entity> myList = new ArrayList<>();
```

A nivel de DDL, se crea una nueva tabla, con _claves externas_ hacia las tablas de las entidades asociadas. 

### Anotaciones adicionales

Además de la anotación `@ManyToMany`, podemos completar esta asociación con algo de metainformación, a través de las siguientes anotaciones: 

- `@JoinTable`: nos permite dar algo de configuración a la tabla _join_ que se genera.
	- `name`: podemos cambiar el nombre por defecto de esta tabla
	- `joinColumns`: nos permite proporcionar una colección indicando los `@JoinColumn` (y esto a su vez, nos permite indicar todas las propiedades de cada `@JoinColumn`, como el `name` , `columnDefinition`, ...
	- `inverseJoinColumns`: nos permite proporcionar una colección de claves externas (similar al anterior) pero que apuntan a la entidad que no posee la asociación _muchos-a-muchos_.

## Tratamiento bidireccional de una asociación `@ManyToMany`

El tratamiento _bidireccional_ de una asociación nos permite utilizar dicha asociación desde las dos entidades que están conectadas. Partimos del código del ejemplo anterior, que hemos modificado un poco añadiendo las asignaturas y su asociación con los cursos:

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, tutor;
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> alumnos = new ArrayList<>();
	
	
	@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<Asignatura> asignaturas = new ArrayList<>();

}

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, apellidos, email;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_alumno_curso"))	
	private Curso curso;
	
		
	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON CURSO
	 */
	
	// Alumno - Curso
	
	public void addToCurso(Curso curso) {
		this.curso = curso;
		curso.getAlumnos().add(this);
	}
	
	public void removeFromCurso(Curso curso) {
		curso.getAlumnos().remove(this);
		this.curso = null;		
	}

}




public class Asignatura {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String profesor;
	
	@ManyToOne
	private Curso curso;
	
	/**
	 * MÉTODOS HELPER
	 */
	
	public void addToCurso(Curso c) {
		c.getAsignaturas().add(this);
		this.curso = c;
		
	}
	
	public void removeFromCurso(Curso c) {
		c.getAsignaturas().remove(this);
		this.curso = null;
	}
	

}


```


## Paso 1: Modificar la entidad `Alumno`

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
	
	// Resto del código
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "matricula",
			joinColumns = @JoinColumn(name="alumno_id"),
			inverseJoinColumns = @JoinColumn(name="asignatura_id")
	)
	@Builder.Default
	private List<Asignatura> asignaturas = new ArrayList<>();
	
	// Resto del código
	
	// Alumno - Asignaturas
	public void addAsignatura(Asignatura a) {
		this.asignaturas.add(a);
		a.getAlumnos().add(this);
	}
	
	public void removeAsignatura(Asignatura a) {
		a.getAlumnos().remove(this);
		this.asignaturas.remove(a);
	}

	

}

```

## Paso 2: Modificar la entidad `Asignatura`

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura {
	
	// Resto del código
	
	@ManyToMany(mappedBy="asignaturas", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Alumno> alumnos = new ArrayList<>();
	
	// Resto del código

}

```

Si ejecutamos el proyecto, podemos apreciar el siguiente DDL generado:

```sql
   create table alumno (
       id bigint not null,
        apellidos varchar(255),
        email varchar(255),
        nombre varchar(255),
        curso_id bigint,
        primary key (id)
    )

    
    create table matricula (
       alumno_id bigint not null,
        asignatura_id bigint not null
    )

    
    create table asignatura (
       id bigint not null,
        nombre varchar(255),
        profesor varchar(255),
        curso_id bigint,
        primary key (id)
    )

    
    create table curso (
       id bigint not null,
        nombre varchar(255),
        tutor varchar(255),
        primary key (id)
    )

    
    alter table alumno 
       add constraint FKojks48ahsqwkx9o2s7pl0212p 
       foreign key (curso_id) 
       references curso

    
    alter table matricula 
       add constraint FKrukf4f8fa1cexj0cwh1m7kpim 
       foreign key (asignatura_id) 
       references asignatura

    
    alter table matricula
       add constraint FKrt0id7bs1lp5qkuyhw9ceustn 
       foreign key (alumno_id) 
       references alumno

    
    alter table asignatura 
       add constraint FKr7icgav26emducg973dp80fga 
       foreign key (curso_id) 
       references curso
```

> Si queremos que la tabla `matricula` tenga una clave primaria compuesta por los dos atributos que conforman la misma, podemos:
> - Utilizar, en lugar de `List`, algún tipo de `Set`: `HashSet`,`LinkedHashSet`, ... 
> - Añadir, en la anotación `@JoinColumn` dentro de `@JoinTable`, el atributo `nullable=false` para ambas columnas.


## Paso 3: Utilizar esta asociación

En este caso, siendo bidireccional, la tenemos que manejar a través de los métodos helpers.

Aquí podemos ver el código de este _main de prueba_:

```java
@Component
@RequiredArgsConstructor
public class MainDeMentira {

	private final AlumnoServicio alumnoServicio;
	private final CursoServicio cursoServicio;
	private final AsignaturaServicio asignaturaServicio;

	@PostConstruct
	public void ejecutar() {

		Alumno a1 = new Alumno();
		a1.setNombre("Pepe");
		a1.setApellidos("Pérez Pérez");
		a1.setEmail("pepe@gmail.com");

		Alumno a2 = new Alumno();
		a2.setNombre("María");
		a2.setApellidos("Ruiz Hidalgo");
		a2.setEmail("lamari14@msn.com");

		alumnoServicio.save(a1);
		alumnoServicio.save(a2);

		Curso c = new Curso();
		c.setNombre("1º DAM");
		c.setTutor("Miguel");

		cursoServicio.save(c);

		a1.addToCurso(c);
		a2.addToCurso(c);

		alumnoServicio.save(a1);
		alumnoServicio.save(a2);

		System.out.println(c);
		for (Alumno a : c.getAlumnos()) {
			System.out.println(a);
		}

		// Creamos un nuevo curso y lo almacenamos
		//Curso primeroDam = Curso("1º DAM", "Miguel Campos");
		Curso primeroDam = Curso.builder()
				.nombre("1º DAM")
				.tutor("Miguel Campos")
				.build();
		cursoServicio.save(primeroDam);

		Asignatura baseDatos = new Asignatura("Bases de Datos", "Luismi"); 
		Asignatura entornos = new Asignatura("Entornos de Desarrollo", "Luismi");
		// Creamos las asignaturas, las guardamos y las añadimos al curso
		List<Asignatura> asignaturas = Arrays.asList(
				baseDatos,
				entornos, 
				new Asignatura("Programación", "Ángel"),
				new Asignatura("Lenguajes de Marcas", "Rafa"));

		for (Asignatura a : asignaturas) {
			a.addToCurso(primeroDam);
			asignaturaServicio.save(a);
		}

		Alumno antonio = new Alumno("Antonio", "Pérez", "antonio.perez@gmail.com");
		
		// Creamos un nuevo conjunto de alumnos
		List<Alumno> nuevos = Arrays.asList(
				antonio,
				new Alumno("María", "López", "maria.lopez@gmail.com"));

		for (Alumno a : nuevos)
			alumnoServicio.save(a);

		// Aquí es donde vinculamos el curso y los alumnos.
		// La entidad Curso es la que tiene los metodos auxiliares
		// aunque en realidad, Alumno es el propietario de la asociación

		for (Alumno a : nuevos) {
			a.addToCurso(primeroDam);
			alumnoServicio.edit(a);
		}
		
		antonio.addAsignatura(baseDatos);
		antonio.addAsignatura(entornos);
		
		alumnoServicio.edit(antonio);

	}

}
```