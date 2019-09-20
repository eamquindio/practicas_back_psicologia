CREATE TABLE public.cita
(
    idCita       bigint PRIMARY KEY,
    fechaHora     DATE NOT NULL,
    psicologoCedula    VARCHAR(30) NOT NULL,
    estudianteId     bigint NOT NULL,
    estado        VARCHAR(45) NOT NULL,
    titulo        VARCHAR(100),
    descripcion    VARCHAR(500)
);