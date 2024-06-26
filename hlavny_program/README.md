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

# Základné inštrukcie a vysvetlenia

Na vstupy používajte výhradne číselné hodnoty, pokiaľ si však program vypíta slovnú odpoveď odpovedajte naopak slovom.

Pokiaľ budete zadávať nezmyslené hodnoty, program na to upozorní a požiada vás zadať hodnotu znova.

Keď budete chcieť zadávať okrem celých čísel aj reálne čísla, je doležité používať desatinnú bodku(.) a nie desatinnú čiarku(,).

Pri zadávaní hodnoty rf môžete voliť ľubovolnú hodnotu, avšak z hľadiska kontroli podmienok je potrebné zadávať reálnu hodnotu.
Príklad 0.02 je úrok na dlhopise 2% z kapitálu. Preto je dôležité zadávať reálne hodnoty použiteľné v bežnom svete. 
Pri zadaní 0.2 je asi nereálne aby vám nejaká inštitúcia vypísala na dlhopis úrok 20% na určité kratšie obdobie,
a samozrejme by musel byť výnos z akcií naozaj veľmi vysoký aby prešiel kontrolou podmienok z programu.

Pri zadávaní hodnôt aH, aD, bH, bD je dôležité, aby ste zadávali reálne hodnoty, ktoré môžu na trhu vzniknúť. Preto je obmedzená výška akcie v udalostiach.
Pokiaľ prekročíte 2*násobok počiatočnej zadanej hodnoty akcie, program upozorní na nerelálne vstupy.

Pri zadávaní hodnôt x0, y0, z0 a m pokiaľ ste sa rozhodli si zadať svoje, je dôležité, aby hondoty x0, y0 a z0 neboli väčšie ako hodnota m.
Aj keď hodnoty x0, y0 a z0 sa zadávajú záporné, program si ich prepočíta aby zistil, či nieje x0, y0 a z0 vačšie ako m. Nie dokopy, ale každé zvlášť.

Pokiaľ budete zadávať generovanie hodnôt, treba pri počiatočných hodnotách akcie a hodnotách na ktoré pôsobí udalosť H či D(A,B,aH,bH,aD,bD) 
je treba, aby čísla boli pri najlepšom celé a párne, pretože by program mohol veľmi dlho hladať kombináciu, aby výsledky čísel x0,y0,z0 a m boli celé čísla
a výsledky hodnôt xOpt, yOpt a zOpt boli tiež celé čísla pre pedagogické účely.

# Cieľ programu

Cieľom programu je nájsť optimálne riešenia z hľadiska arbitráže optimálne riešenie, tj. také, ktoré umožní vhodnou kúpou/predajom
akcií bez dividend vytvoriť arbitráž, čiže bezrizikový kladný zisk s prázdnym vreckom.

# Vysvetlenie jednotlivých vstupov do programu 

Vstupy  **A**, **B** sú počiatočné hodnoty cien akcií A a B. Reprezentujú hodnotu akcií A,B pred vstupom do investícií.

Vstupy **aH** a **bH** sú hodnoty budúcej ceny akcií pri pôsobení udalosti $H$.

Vstupy **aD** a **bD** sú hodnoty budúcej ceny akcií pri vzniku udalosti $D$.

**Rf** je úroková miera. Reprezentuje úroveň bezrizikových úrokových sadzieb  dlhopisov, ovplyvňuje výpočtové operácie v programe.

Hodnota **m** značí investície alebo kapitál, ktorý je k dispozícii na investovanie do akcií a dlhopisov.

Hodnoty **x0** **y0** reprezentujú koľko finančných prostriedkov vlastní investor  v čase 0 v akcií A resp. B.

Hodnota **z0** reprezentuje koľko si dokáže investor emitáciou dlhopisov v čase 0 požičať.

# Skušobné hodnoty pre inšpiráciu

A = 20, B = 50, aH = 24, aD = 16, bH = 40, bD = 55, rf = 0.04, m = 7000, x0,y0,z0 = 0
A = 30, B = 40, aH = 33, aD = 24, bH = 44, bD = 36, rf = 0.05, m = 45000, x0 = 0, y0 = -5600, z0 = -29800
A = 10, B = 20, aH = 8, aD = 14, bH = 22, bD = 8, rf = 0.08, m = 6000, x0 = -100, y0 = 0, z0 = -2400
A = 50, B = 60, aH = 45, aD = 55, bH = 54, bD = 72, rf = 0.02, m = 40000, x0 = -2100, y0 = -32300, z0 = -30700

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

# Basic instructions and explanations

Use only numerical values for inputs, but if the program asks for a verbal answer, answer with a word instead.

If you enter nonsense values, the program will alert you and ask you to enter the value again.

When you want to enter real numbers in addition to whole numbers, it is important to use a decimal point (.) and not a decimal point (,).

When entering the rf value, you can choose any value, but from the point of view of checking the conditions, 
it is necessary to enter a real value. Example 0.02 is interest on a bond of 2% of capital. That's why it's 
important to enter real values that can be used in the real world. When entering 0.2, it is probably unrealistic 
for some institution to write you an interest rate of 20% on a bond for a certain shorter period, and 
of course the yield from the shares would have to be really very high to pass the check of the conditions of the program.

When entering the values of aH, aD, bH, bD, it is important that you enter real values that can arise in the market. Therefore, the amount of action in the events is limited.
If you exceed 2* times the initial value of the action, the program will warn about unrealistic inputs.

When entering the values of x0, y0, z0 and m if you have decided to enter your own, it is important that the x0, y0 and z0 values are not greater than the value of m.
Even if the x0, y0 and z0 values are entered as negative, the program recalculates them to see if x0, y0 and z0 are greater than m. Not together, but separately.

If you are going to enter the generation of values, for the initial values of the action and the values affected by the event H or D(A,B,aH,bH,aD,bD)
it is necessary that the numbers are at best whole and even, because the program could search for a combination for a very long time so that the results of the numbers x0,y0,z0 and m are whole numbers
and the results of the xOpt, yOpt, and zOpt values were also integers for pedagogical purposes.

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

# Trial values for inspiration

A = 20, B = 50, aH = 24, aD = 16, bH = 40, bD = 55, rf = 0.04, m = 7000, x0,y0,z0 = 0
A = 30, B = 40, aH = 33, aD = 24, bH = 44, bD = 36, rf = 0.05, m = 45000, x0 = 0, y0 = -5600, z0 = -29800
A = 10, B = 20, aH = 8, aD = 14, bH = 22, bD = 8, rf = 0.08, m = 6000, x0 = -100, y0 = 0, z0 = -2400
A = 50, B = 60, aH = 45, aD = 55, bH = 54, bD = 72, rf = 0.02, m = 40000, x0 = -2100, y0 = -32300, z0 = -30700