
import { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import { FiArrowRightCircle, FiArrowLeftCircle } from 'react-icons/fi'
import { Table } from 'react-bootstrap'

import logoImage from '../../assets/images/user.png'

import '../cadastros/styles.css'

import NavBar from '../../componets/basics/navbar';
import Footer from '../../componets/basics/footer';
import API from '../../services/API';

type iCadastros = {
  codigo_cadastro: number
  nome_cadastro: string
  email_cadastro: string
}


const Cadastros: React.FC = () => {

  const [cadastros, setCadastros] = useState<iCadastros[]>([]);

  const nome_cadastro = localStorage.getItem('nome_cadastro')
  const email_cadastro = localStorage.getItem('email_cadastro')

  const history = useHistory();

  async function loadCadastros(){
    const response = await API.get('v1/pp/cadastros')

    setCadastros(response.data._embedded.cadastroDTOList)
  }

  useEffect(()=>{loadCadastros()})

  return (
    <>
    <div>
      <NavBar />
    </div>

    <div className="cadastros-container">
      <header>
        <img src={logoImage} alt="Job Pool" />
        <span>Bem-vindo, <strong>{"Cadastros"}</strong>!</span>
      </header>

      <h1>Empresas Cadastradas</h1>

      <Table striped bordered hover className="text-center">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {
            cadastros.map(p => (
            <tr>
              <td>{p.codigo_cadastro}</td>
              <td>{p.nome_cadastro}</td>
              <td>{p.email_cadastro}</td>
            </tr>
            ))
          }
        </tbody>
      </Table>
    </div>
  <div>
  <Footer />
  </div>
  </>
  );
}
export default Cadastros;