# ChaCha20

- Se para duas pessoas trocarem informações, é necessário uma chave...
- Quantas chaves são necessárias para três pessoas trocarem informações??
- Se para duas pessoas trocarem informações, é necessário uma chave...
- E para três pessoas trocarem informações, são necessárias 3 chaves...
- Quantas chaves são necessárias para 4 pessoas trocarem informações??

n(C)2 = n(n-1)/2

- Os usuários devem ter cuidado em como armazenam e trocam chaves;
- Normalmente o processo de encriptar e decriptar é rápido;
- É o mais indicado para grande quantidade de dados;
- Não é indicado para comunicação com várias pessoas, devido a necessidade de criação e gestão de muitas chaves;

# Cifra de fluxo (Stream):

- Cada bit ou byte é encriptado individualmente, em sequência.

- ChaCha20 é formado por
-- Constante de 128 bits
-- Chave de 256 bits
-- Contador de 32 bits
-- Nonce (número pseudoaleatório que só pode ser usado uma vez) de 96 bits
