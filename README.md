Návod k použití
===============

- data.csv vznikne exportem z QuickEvent aplikace, musejí vzniknout sloupce:

    firstName,lastName,NAME,siId,startTime,finishTime,punches

V SQL Monitoru zadat:

    SELECT firstName,lastName,NAME,cards.siId,startTime,finishTime,punches
    FROM main.cards JOIN main.competitors JOIN main.runs JOIN main.classes
    ON main.cards.runId == main.runs.id AND main.runs.competitorId == main.competitors.id AND main.competitors.classId == main.classes.id

Příp. přidat `cards.stageId`.

Použít v kontextovém menu Export / CSV, změnit oddělovač polí na čárku.

- Dát soubor data.csv do adresáře data
- spustit Main
- v souboru data-out.csv jsou výsledky
