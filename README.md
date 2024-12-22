# Documentation projet ASSURANCE_BACKEND
## les explications des endpoints
### implementation des JWT(Json Web Tokens)
### --------------------------
#### premierement il faut creer un compte utilisateur --- "/auth/addNewUser"
#### ensuite generer le Token ---- "/auth/generateToken"
#### utiliser le Token genere pour se connecter (en fonction de type d'utilisateur(ROLE_USER ou ROLE_ADMIN) un token sera genere et utilise pour l'authentification) ----
#### "/auth/user/userProfile" ---- pour un utilisateur avec pour role "ROLE_USER"
#### "/auth/admin/adminProfile" ---- pour un utilisateur avec pour role "ROLE_ADMIN"
#### --------------------------
### Implementation du CRUD
### ---------------------------
#### Ajout d'un produit --- "/produit/addproduit"
#### suppression d'un produit --- "/produit/del_id/{id}"
#### selection d'un produit par l'identifiant --- "/produit/id/{id}"
#### selection de tous les produits --- "/produit/"
#### Modification d'un produit --- "/produit/put_id"


### ----------------------------
#### Ajout d'une souscription ---- "/souscription/addsousc"
#### suppression d'une souscription ---- "/souscription/del_id/{id}"
#### selection d'une souscription par l'identifiant ---- "/souscription/id/{id}"
#### selection de toutes les souscription ---- "/souscription/"
#### Modification d'une souscription ---- "/souscription/put_id/{id}"
