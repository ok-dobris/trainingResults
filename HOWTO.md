# Jak založit závod v QuickEvent

- pokud budeme používat import přes závod v ORISu, závod založíme v ORISu a naimportujeme
- jinak založíme závod přímo v QuickEvent (Soubor / Závod / Vytvořit závod)
  - pro každý trénink používám nový adresář
  - id závodu dávám dorxcYYYYMM, např. dorXC202006

- založit trať
   - Kategorie
      - Upravit / Kontroly
         - přidat kontroly 31..35 (vyplňuje se sloupec Kontrola)
      - Upravit / Tratě
         - přidat trať jméno XC
         - do ní přidat kontroly 31..35
         - zadat délku 1000, převýšení 50
      - založit kategorii T (příp. možno i další, pokud budou uvedeny v seznamu závodníků níže)
      - všem kategoriím dát trať XC
      
### Import závodníků

####  Přes závod v ORISu

- založíme závod v ORISu
- přihlásíme všechny členy oddílu (automaticky vybere kategorie?)
- v QuickEvent dáme Soubor / Importovat / ORIS / Závod

#### Exportem z ORISu

- v ORISu otevřeme https://oris.orientacnisporty.cz/ClenoveKlubu?id=31&edit_date=1&only_valid=1 (Členové klubu / Editovat členy klubu)
- klikneme na "Exportovat členy do excelu"
- otevřeme tabulku (v Excelu, LibreOffice, Google Docs..)
- přeházíme sloupce do pořadí
   - registrační číslo
   - kategorie (vytvoříme nový sloupec, vyplníme buď všude T, nebo podle skutečnosti)
   - číslo SI čipu
   - příjmení
   - jméno
   - licence (stačí prázdný sloupec)
   - poznámka (stačí prázdný sloupec)
 (V LibreOffice se přehazování dělá pomocí Cut / Paste a vkládání a mazání sloupců)
 - dáme Uložit jako CSV, kódování: UTF-8, oddělovač řádků: čárka, oddělovač řetězců: uvozovky 
 - v QuickEvent dáme Soubor / Importovat / Textový soubor / Seznam závodníků ve formátu CSV