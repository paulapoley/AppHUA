# AppHUA+

Este repositorio contiene el proyecto de la asignatura de Gestión de Servicios y Tecnologías de la Información del grado de Ingeniería de la Salud.

**La aplicación desarrollada, HUA+, está enfocada en la gestión y provisión de información sobre la Hemorragia Uterina Anormal (HUA), dirigida tanto a pacientes como a profesionales médicos.**

## Descripción del Proyecto

HUA+ es una aplicación móvil desarrollada en **Android Studio** utilizando **Kotlin**. La aplicación está diseñada para proporcionar información médica relevante, facilitar la gestión de citas médicas y ofrecer un acceso personalizado para distintos tipos de usuarios.

## Estructura del Repositorio

- `/src/`: Código fuente de la aplicación desarrollada.
- `/docs/`: Incluye la planificación, estimación de costes, análisis de riesgos y otros documentos relevantes del proyecto. También contiene:
  - Modelos de procesos creados en **BonitaSoft**.
  - Prototipos creados con **Moqups** y otros recursos de diseño.
  - El documento [`APP-HUA+.pdf`](docs/APP-HUA+.pdf), que se encuentra dividido en dos partes: **BPMN** y la parte visual de la aplicación móvil. 

## Modelado de Procesos

Utilizando **BonitaSoft**, se han diseñado las organizaciones por grupos, roles y usuarios, así como los caminos y puertas necesarios para la correcta gestión del flujo de trabajo dentro de la aplicación.

## Funcionalidades Principales

### Acceso y Registro de Usuarios:

- **Pacientes**: Registro y autenticación mediante **Firebase Authentication**.
- **Médicos**: Acceso a la información médica y gestión de citas.
- **Usuarios Generales**: Acceso a información sobre la HUA sin necesidad de ser pacientes.

### Gestión de Citas:

- Solicitud de citas médicas.
- Visualización del historial de citas.
- Cancelación de citas.

### Información sobre HUA:

- Descripción de la HUA, signos y síntomas.
- Causas y peligrosidad de la HUA.
- Métodos de diagnóstico y tratamiento.
- Consejos sobre el cuidado personal y cómo contactar con un médico.

### Perfil del Paciente:

- Visualización y gestión de la información personal del paciente.
