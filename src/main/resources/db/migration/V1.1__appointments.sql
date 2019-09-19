CREATE TABLE public.appointments
(
    id_appointment       bigint PRIMARY KEY,
    date_time     Date NOT NULL,
    id_psychologist     VARCHAR(50) NOT NULL,
    id_student     VARCHAR(50) NOT NULL,
    status     VARCHAR(50) NOT NULL
);