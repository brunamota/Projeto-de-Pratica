import { useState } from 'react'
import { useHistory } from 'react-router-dom';
import NavBar from '../../componets/basics/navbar';
import '../login/style.css'
import Lock from '../../assets/images/login.png'
import Footer from '../../componets/basics/footer';

import { MdMailOutline, MdAccountCircle } from "react-icons/md"

import API from '../../services/API';

function Login() {
  const [nome_cadastro, setUserName] = useState("")
  const [email_cadastro, setEmail] = useState("")


  const [show, setShow] = useState(false)

  const history = useHistory();

  async function Login(e: any) {
    e.preventDefault();

    const data = {
      nome_cadastro,
      email_cadastro,
    }
    try {
      console.log("oi")
      
      const response = await API.post('v1/pp/cadastros', data);

      console.log("ok")

      localStorage.setItem('nome_cadastro', response.data.nome_cadastro);
      localStorage.setItem('email_cadastro', response.data.email_cadastro);

      history.push('/cadastros')

    } catch (error) {
      alert('Autenticação sem sucesso, tente novamente!')

    }
  }

  const handleClick = (e: any) => {
    e.preventDefault()
    setShow(!show);
  }

  return (
    <>
      <div className="header">
        <NavBar />
      </div>
      <div className="login">
        <div className="login-logo">
          <img
            src={Lock}
            alt="MdLockLogin App"
          />
        </div>
        <form onSubmit={Login}>
          <div className="login-right">
            <h1><strong>LOGIN</strong></h1>

            <div className="login-loginInputUser">
              <MdAccountCircle />
              <input
                type="user"
                placeholder="Digite seu nome"
                value={nome_cadastro}
                onChange={e => setUserName(e.target.value)}
              />
            </div>

            <div className="login-loginInputPassword">
              <MdMailOutline />
              <input
                placeholder="Digite seu email"
                type={show ? "text" : "email_cadastro"}
                value={email_cadastro}
                onChange={e => setEmail(e.target.value)}
              />

            </div>

            <button type="submit">
              ENTRAR
            </button>
          </div>
        </form>
      </div>
      <div className="header">
        <Footer />
      </div>
    </>
  )
}

export default Login
