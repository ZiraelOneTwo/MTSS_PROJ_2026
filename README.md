# MTSS_PROJ_2026

[![Build Status](https://github.com/ZiraelOneTwo/MTSS_PROJ_2026/actions/workflows/contiguous_integration.yml/badge.svg)](https://github.com/ZiraelOneTwo/MTSS_PROJ_2026/actions)
[![Coverage Status](https://github.com/ZiraelOneTwo/MTSS_PROJ_2026/badge.svg?branch=master)](https://coveralls.io/github/ZiraelOneTwo/MTSS_PROJ_2026?branch=master)

Progetto per il corso **Metodi e Tecnologie per lo Sviluppo del Software (MTSS)**.

Il repository contiene una piccola libreria Java (Maven) che:

- converte interi in numeri romani (1..1000)
- stampa la rappresentazione **ASCII Art** del numero romano

## Funzionalità

### 1) Conversione Integer → Numero romano

La classe `IntegerToRoman` espone un metodo statico:

- `IntegerToRoman.convert(int number)`

**Vincoli**:
- accetta solo valori interi nell’intervallo `1..1000`
- per input fuori intervallo lancia `IllegalArgumentException`

### 2) Stampa in ASCII Art

La classe `RomanPrinter` permette di ottenere una rappresentazione testuale “a matrice” del numero romano:

- `RomanPrinter.print(int num)`

Internamente converte l’intero in romano usando `IntegerToRoman.convert` e poi compone le “lettere” (`I`, `V`, `X`, `L`, `C`, `D`, `M`) in altezza 5 righe.

## Requisiti

- **Java 15** (come da `maven.compiler.source` / `maven.compiler.target` nel `pom.xml`)
- **Maven 3.x**

## Struttura del progetto

- `src/main/java/it/unipd/mtss/IntegerToRoman.java`
  - conversione da intero a numero romano

- `src/main/java/it/unipd/mtss/RomanPrinter.java`
  - generazione ASCII Art a partire dal numero romano

- `src/main/java/it/unipd/mtss/App.java`
  - entrypoint di esempio (attualmente stampa "Hello World!")

## Build, test e quality checks

Eseguire validazione (include **Checkstyle**) e test (include report **JaCoCo**):

```bash
mvn clean verify
```

Eseguire solo i test:

```bash
mvn test
```

## Esempi di utilizzo

### Conversione a numero romano

```java
import it.unipd.mtss.IntegerToRoman;

String roman = IntegerToRoman.convert(42); // "XLII"
```

### Stampa ASCII Art

```java
import it.unipd.mtss.RomanPrinter;

String art = RomanPrinter.print(42);
System.out.println(art);
```

## CI, Coverage e strumenti

- **GitHub Actions**: workflow in `.github/workflows/contiguous_integration.yml`
- **Checkstyle**: configurazione in `checkstyle.xml` (eseguito nella fase `validate`)
- **JaCoCo**: report di copertura generato nella fase `verify`

[![Integrazione continua (Build, Test, Analisi)](https://github.com/ZiraelOneTwo/MTSS_PROJ_2026/actions/workflows/continuous_integration.yml/badge.svg)](https://github.com/ZiraelOneTwo/MTSS_PROJ_2026/actions/workflows/continuous_integration.yml)
[![Coverage Status](https://coveralls.io/repos/github/ZiraelOneTwo/MTSS_PROJ_2026/badge.svg?branch=master)](https://coveralls.io/github/ZiraelOneTwo/MTSS_PROJ_2026?branch=master)

## Licenza

Vedi file [LICENSE](LICENSE).
