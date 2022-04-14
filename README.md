# Criptografia Simétrica

- Os usuários devem ter cuidado em como armazenam e trocam chaves;
- Normalmente o processo de encriptar e decriptar é rápido;
- É o mais indicado para grande quantidade de dados, porém não é indicado para comunicação com várias pessoas, devido a necessidade de criação e gestão de muitas chaves;

# ChaCha20

- É uma cifra de fluxo
- Se para duas pessoas trocarem informações, é necessário uma chave... para três pessoas trocarem informações, são necessárias 3 chaves...
- Quantas chaves são necessárias para 4 pessoas trocarem informações?? a formula abaixo responde, sendo ``n`` o número de pessoas

``
C = n(n-1)/2
``

# Cifra de fluxo (Stream):

- Cada bit ou byte é encriptado individualmente, em sequência.

- ChaCha20 é formado por
  - Constante de 128 bits
  - Chave de 256 bits
  - Contador de 32 bits
  - Nonce (número pseudoaleatório que só pode ser usado uma vez) de 96 bits
