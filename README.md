Výsledky tréninky - více výsledků na osobu
==========================================

Program vznikl k vyhodnocení měřeného XC okruhu, kde je třeba pro jednoho závodníka znát výsledky
z více běhů na stejné trati. 

Návod k použití
===============
- V QuickEventu normálně měříme časy, jako když se pořádá závod.

- z QuickEvent aplikace, vyexportujeme data.csv musejí vzniknout sloupce:

    `firstName,lastName,NAME,siId,startTime,finishTime,punches`

    V SQL Monitoru zadat:

    ```sql
    SELECT firstName,lastName,NAME,cards.siId,startTime,finishTime,punches
    FROM main.cards JOIN main.competitors JOIN main.classes
    ON main.cards.siId == main.competitors.siId AND main.competitors.classId == main.classes.id
    ```

    Příp. přidat ještě `cards.stageId`.

    Použít v kontextovém menu `Export` / `CSV`, změnit oddělovač polí na čárku.

- Dát soubor `data.csv` do adresáře `data` (aby byl na relativní cestě `data/data.csv`)
- spustit `Main`
- v souboru `data/data-out.csv` jsou výsledky
