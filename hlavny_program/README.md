# Program na vyhodnotenie podmienok investícií do akcií a dlhopisov

Tento program je určený na vyhodnocovanie podmienok investícií do akcií a dlhopisov na základe zadaných parametrov. 
Umožňuje analyzovať a rozhodovať o správnych investičných stratégiách v závislosti od rôznych scenárov a podmienok trhu.
Určené pre študentov na edukatívne účely.

## Použitie

1. Stiahnite si tento repozitár/súbor na svoj počítač.

2. V adresári projektu spustite programovacie prostredie Java.

3. Spustite súbor `Main.java`.

4. Nasledujte inštrukcie programu na zadanie počiatočných vstupných hodnôt a parametrov investícií.

5. Program vám poskytne výsledky vyhodnotenia podmienok investícií.

# Základné inštrukcie

Na vstupy používajte výhradne číselné hodnoty, pokiaľ si však program vypíta slovnú odpoveď odpovedajte naopak slovom.

Pokiaľ budete zadávať nezmyslené hodnoty, program na to upozorní a požiada vás zadať hodnotu znova.

Keď budete chcieť zadávať okrem celých čísel aj reálne čísla, je doležité používať desatinnú bodku(.) a nie desatinnú čiarku(,).

# Cieľ programu

Cieľom programu je nájsť optimálne riešenia z hľadiska arbitráže optimálne riešenie, tj. také, ktoré umožní vhodnou kúpou/predajom
akcií bez dividend vytvoriť arbitráž, čiže bezrizikový kladný zisk s
prázdnym vreckom.

# Vysvetlenie jednotlivých vstupov do programu 

Vstupy  **A**, **B** sú počiatočné hodnoty cien akcií A a B. Reprezentujú hodnotu akcií A,B pred vstupom do investícií.

Vstupy **aH** a **bH** sú hodnoty budúcej ceny akcií pri pôsobení udalosti $H$.

Vstupy **aD** a **bD** sú hodnoty budúcej ceny akcií pri vzniku udalosti $D$.

**Rf** je úroková miera. Reprezentuje úroveň bezrizikových úrokových sadzieb  dlhopisov, ovplyvňuje výpočtové operácie v programe.

Hodnota **m** značí investície alebo kapitál, ktorý je k dispozícii na investovanie do akcií a dlhopisov.

Hodnoty **x0** **y0** reprezentujú koľko finančných prostriedkov vlastní investor  v čase 0 v akcií A resp. B.

Hodnota **z0** reprezentuje koľko si dokáže investor emitáciou dlhopisov v čase 0 požičať.

**_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _**

# Program for evaluating the terms of investments in stocks and bonds

This program is intended for evaluating the conditions of investments in shares and bonds based on the specified parameters.
It allows you to analyze and decide on the right investment strategies depending on different scenarios and market conditions.
Intended for students for educational purposes.

## The use

1. Download this repository/file to your computer.

2. Start the Java programming environment in the project directory.

3. Run the `Main.java` file.

4. Follow the instructions of the program to enter initial input values and investment parameters.

5. The program will provide you with the results of the evaluation of investment conditions.

# Basic instructions

Use only numerical values for inputs, but if the program asks for a verbal answer, answer with a word instead.

If you enter nonsense values, the program will alert you and ask you to enter the value again.

When you want to enter real numbers in addition to whole numbers, it is important to use a decimal point (.) and not a decimal point (,).

# The goal of the program

The goal of the program is to find optimal solutions from the point of view of arbitration, the optimal solution, i.e. such that will enable a suitable purchase/sale
shares without dividends to create arbitrage, i.e. a risk-free positive profit with
an empty pocket.

# Explanation of individual inputs to the program

Inputs **A**, **B** are the initial values of the prices of shares A and B. They represent the value of shares A,B before entering the investments.

The inputs **aH** and **bH** are the values of the future price of the shares upon the action of the event $H$.

The inputs **aD** and **bD** are the values of the future price of the shares upon the action of the event $D$.

**Rf** is the interest rate. It represents the level of risk-free interest rates of bonds, it affects the calculation operations in the program.

The **m** value represents the investments or capital that is available to invest in stocks and bonds.

The values **x0** **y0** represent how much funds the investor owns at time 0 in shares A or B.

The value **z0** represents how much the investor can borrow by issuing bonds at time 0.
