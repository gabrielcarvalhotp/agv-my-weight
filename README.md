# AGV Meu Peso - Sistema de controle de peso corporal 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gabrielcarvalhotp/agv-my-weight/blob/master/LICENSE)

## Sobre o projeto
Aplicação mobile Android nativo, contemplando autenticação, autorização, gerenciamento de perfis, histórico e registro de peso.

## Objetivo do Projeto
* Consolidar conhecimentos em Android com Jetpack Compose
* Trabalhar com modelagem de domínio 
* Consolidar conhecimentos com Firebase
* Servir como projeto de portfólio Android Kotlin

## Arquitetura do Projeto
```text
app/kotlin+java
 └── br.com.agvsistemas.myweigth
     ├── core/
     │   └── di/
     ├── data/
     │   ├── models/
     │   ├── repositories/
     │   └── remote/     
     ├── designsystem/
     │   ├── components/
     │   └── theme/
     ├── ui/
     │   ├── components/
     │   ├── features/     
     │   └── navigation/     
     └── MainActivity.kt
```

## Tecnologias Utilizadas
* Kotlin
* Jetpack Compose
* Koin
* Firebase

