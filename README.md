# Nouari3A

Mon application est une application de suivi de cas de COVID-19 qui affiche le nombre de contaminés, de cas actifs, de cas guéris et le nombre de mort en temps réel (chaque jour) 

Elle suit une API Covid 19 sur ce lien https://api.covid19api.com/countries

L'Api qui fournit les drapeaux est celle-ci https://www.countryflags.io/fr/flat/64.png où on remplace ici "fr" par le code ISO2 du pays souhaité.

La liste est affiché avec une RecyclerView, les données sont stockés en cache et il y a une architecture MVVM ainsi que la Logic dans le ViewModel


## A savoir

Il se peut que j'ai mal configuré mon github mais mon projet se trouve sous la branche qui se nomme "developp" et non pas "master" 

### Screens
Sur cette image on voit la liste des pays :

![](https://media.discordapp.net/attachments/396036786352029697/845626068429963264/unknown.png?width=261&height=586)

Ici, on a le détail pour un pays : l'Allemagne 

![](https://media.discordapp.net/attachments/396036786352029697/845626173023453205/unknown.png?width=274&height=586)

Là, pour un autre pays, Latvia

![](https://media.discordapp.net/attachments/396036786352029697/845626233424969728/unknown.png?width=265&height=586)


Lorsque l'on active le mode avion et qu'on reclique sur l'Allemgne, les données sont stockés en cache donc on a ca : 

![](https://media.discordapp.net/attachments/396036786352029697/845627360526598144/unknown.png?width=261&height=586)


Et si on éteint l'application et qu'on la rallume en mode Avion, on a un écran d'échec de connexion : 

![](https://media.discordapp.net/attachments/396036786352029697/845626420213317672/unknown.png?width=280&height=585)
