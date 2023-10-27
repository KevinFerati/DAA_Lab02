# Rapport Labo 02 DAA
- Flavio Sovilla
- Kevin Ferati
- Malo Romano

## 1. Les Activités
### Que se passe-t-il si l’utilisateur appuie sur « back » lorsqu’il se trouve sur la seconde Activité ? 
La seconde activité est arrêtée et détruite.
La première activité est redémarrée.

### Diagrammes d'état
#### L’utilisateur ouvre l’application, clique sur le bouton éditer, renseigne son prénom et sauve. 
##### _MainActivity_
```mermaid
  graph LR
    A((Initial)) -- Utilisateur lance l'appli --> B[onCreate]
    B --> C[onStart]
    C --> D[onResume]
    D -- Utilisateur clique sur Editer --> F[onPause]
    F --> G{Autre activité}
    G -- Utilisateur revient \nen arrière --> I[onRestart]
    I --> C
```

##### _NameInputActivity_
```mermaid
  graph LR
    A((Initial)) -- Utilisateur lance l'appli --> B[onCreate]
    B --> C[onStart]
    C --> D[onResume]
    D -- Saisit son nom \net valide --> F[onPause]
    F --> G[onStop]
    G --> H[onDetroy]
    H --> I{Redirection vers\nl'activité principale}
    
```
