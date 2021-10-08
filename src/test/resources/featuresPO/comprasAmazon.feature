#language: pt
Funcionalidade: Comprar Produto PO
  Cenario: Pesquisar Produto e Incluir no Carrinho
    Dado que acesso o site da Amazon
    Quando pesquiso por "Cafeteira Single, Vermelho, 110v, Cadence"
    E clico na Lupa
    Entao vejo a lista de resultados para o produto "Cafeteira Single, Vermelho, 110v, Cadence"
    Quando clico sobre o produto definido
    Quando clico adicionar produto no carrinho
    Quando acesso carrinho de compras
    Entao confirmo o nome do produto como "Cafeteira Single, Vermelho, 110v, Cadence" e o preco de "R$ 97,79"

  Cenario: Pesquisar Produto com Enter e Incluir no Carrinho
    Dado que acesso o site da Amazon
    Quando pesquiso por "Cafeteira Single, Vermelho, 110v, Cadence"
    E pressiono Enter
    Entao vejo a lista de resultados para o produto "Cafeteira Single, Vermelho, 110v, Cadence"
    Quando clico sobre o produto definido
    Quando clico adicionar produto no carrinho
    Quando acesso carrinho de compras
    Entao confirmo o nome do produto como "Cafeteira Single, Vermelho, 110v, Cadence" e o preco de "R$ 97,79"
