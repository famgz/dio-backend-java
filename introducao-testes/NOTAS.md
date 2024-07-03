## Níveis de Teste

Testes de unidade

Testes de integração

Testes de Sistema (usuários)

Testes de Regressão (selenium)

Testes de Aceitação (feedback) BDD behaviour driven development


Tipos testes Sistema
- alpha (inicial)
- beta (mais amplo)
- canary (entrega continua)



## Técnicas de Teste

Caixa branca
	teste estrutural
	validar dados, controles, fluxos, chamadas
	garantir qualidade da implementação
	níveis: unidade, integração, Regressão

Caixa preta
	teste funcional
	verificar saídas usando vários tipos de entrada
	teste sem conhecer a estrutura interna do software
	níveis: integração, sistema, aceitação

Caixa cinza
	mescla técnicas de caixa branca e caixa preta
	analise parte lógica e também funcionalidade
	exemplo: ter acesso a documentação do funcionamento do código
	engenharia reversa



## Testes não Funcionais

ligados a:
- comportamento do Sistema
- performance
- escalabilidade
- segurança
- infraestrutura


Teste de carga
	verificar volume de transações, acessos ou usuários que um sistema suporta
	
Teste de stress
	submeter o software a situações extremas, testar limites
	

## Pirâmide de Testes
UI tests > Service tests > Unit tests

