Návod k použití
===============

- data.csv vznikne exportem z QuickEvent aplikace, musejí vzniknout sloupce:

    firstName,lastName,NAME,siId,startTime,finishTime,punches

V SQL Monitoru zadat:

    SELECT firstName,lastName,NAME,cards.siId,startTime,finishTime,punches
    FROM main.cards JOIN main.competitors JOIN main.runs JOIN main.classes
    ON main.cards.runId == main.runs.id AND main.runs.competitorId == main.competitors.id AND main.competitors.classId == main.classes.id

Příp. přidat `cards.stageId`.


Udělat copy special, změnit oddělovač polí na čárku.

Potom nahradit \n odřádkováním (zatím nutno ručně) a doplnit záhlaví.
