document.addEventListener('DOMContentLoaded', () => {
    // Entity Selection
    const entitySelector = document.getElementById('entitySelector');
    const entityForms = document.querySelectorAll('.entityForm');
    const dataListItems = document.getElementById('dataListItems');

    // Show Forms
    entitySelector.addEventListener('change', function() {

        entityForms.forEach(form => form.style.display = 'none');

        const selectedForm = document.getElementById('form' + entitySelector.value);
        if (selectedForm) {
            selectedForm.style.display = 'block';
        }

        let endpoint = '';
        switch (entitySelector.value) {
            case 'Funcionario':
                endpoint = '/api/funcionarios';
                break;
            case 'ContasDoMes':
                endpoint = '/api/contasdomes';
                break;
            case 'Veiculos':
                endpoint = '/api/veiculos';
                break;
            case 'Servicos':
                endpoint = '/api/servicos';
                break;
        }
        fetchData(endpoint);
    });

    // Post
    async function addData(endpoint, data) {
        try {
            const response = await fetch(endpoint, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            });
            if (response.ok) {
                fetchData(endpoint);
            } else {
                console.error('Erro ao adicionar o dado');
            }
        } catch (error) {
            console.error('Erro ao fazer a solicitação', error);
        }
    }

    // Data listing
    async function fetchData(endpoint) {
        try {
            const response = await fetch(endpoint);
            const data = await response.json();
            dataListItems.innerHTML = ''; // Limpa a lista atual
            data.forEach(item => {
                const li = document.createElement('li');
                let itemText = '';

                switch (entitySelector.value) {
                    case 'Funcionario':
                        itemText = `CPF: ${item.cpf}, Nome: ${item.nome}, Salário: ${item.salario}`;
                        break;
                    case 'ContasDoMes':
                        itemText = `Descrição: ${item.descricao}, Valor: ${item.valor}, Data de Cadastro: ${item.dt_Cadastro}`;
                        break;
                    case 'Veiculos':
                        itemText = `Placa: ${item.placa}, Modelo: ${item.modelo}, Marca: ${item.marca}, Ano Modelo: ${item.anoModelo}, Ano Fabricação: ${item.anoFabricacao}, Cor: ${item.cor}, Preço: ${item.preco}`;
                        break;
                    case 'Servicos':
                        itemText = `Descrição: ${item.descricao}, Data de Cadastro: ${item.dt_Cadastro}`;
                        break;
                }

                li.textContent = itemText;
                dataListItems.appendChild(li);
            });
        } catch (error) {
            console.error('Erro ao buscar os dados', error);
        }
    }

    // Form Sender
    document.querySelectorAll('.entityForm').forEach(form => {
        form.addEventListener('submit', (event) => {
            event.preventDefault();

            let endpoint = '';
            let newData = {};

            switch (entitySelector.value) {
                case 'Funcionario':
                    endpoint = '/api/funcionarios';
                    newData = {
                        cpf: document.getElementById('cpf').value,
                        nome: document.getElementById('nomeFuncionario').value,
                        salario: parseFloat(document.getElementById('salario').value),
                    };
                    break;
                case 'ContasDoMes':
                    endpoint = '/api/contasdomes';
                    newData = {
                        descricao: document.getElementById('descricao').value,
                        valor: parseFloat(document.getElementById('valor').value),
                        dt_Cadastro: document.getElementById('dtCadastroConta').value,
                    };
                    break;
                case 'Veiculos':
                    endpoint = '/api/veiculos';
                    newData = {
                        placa: document.getElementById('placa').value,
                        modelo: document.getElementById('modelo').value,
                        marca: document.getElementById('marca').value,
                        anoModelo: parseInt(document.getElementById('anoModelo').value),
                        anoFabricacao: parseInt(document.getElementById('anoFabricacao').value),
                        cor: document.getElementById('cor').value,
                        preco: parseFloat(document.getElementById('preco').value),
                    };
                    break;
                case 'Servicos':
                    endpoint = '/api/servicos';
                    newData = {
                        descricao: document.getElementById('descricaoServico').value,
                        dt_Cadastro: document.getElementById('dtCadastroServico').value,
                    };
                    break;
            }

            addData(endpoint, newData);
        });
    });
});
