CREATE TABLE public.cita
(
    id_cita       bigint PRIMARY KEY,
    fecha_hora     DATE NOT NULL,
    psicologo_cedula    VARCHAR(30) NOT NULL,
    estudiante_id     VARCHAR(30) NOT NULL,
    estado        VARCHAR(45) NOT NULL,
    titulo        VARCHAR(100),
    descripcion    VARCHAR(500)
);