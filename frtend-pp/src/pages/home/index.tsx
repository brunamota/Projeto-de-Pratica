import { FiLogIn } from 'react-icons/fi';

import '../home/style.css'
import logo from '../../assets/images/capa.jpg';
import Footer from '../../componets/basics/footer';
import NavBar from '../../componets/basics/navbar';
import { Link } from 'react-router-dom';

const Home: React.FC = () => {
  return (
    <>
      <div id="header">
      <NavBar />
      </div>
      <div id="conteudo">
        <div id="contentl">
          <p><h1><strong>Projeto de Prática Final - DAW</strong></h1></p>
          <p></p>
          <Link to="/login">
            <span>
              <FiLogIn />
            </span>
            <strong>Acessar o sistema</strong>
          </Link>
        </div>
        <div id="contentr">
          <img src={logo} alt="Job Pool" />
        </div>
      </div>
      <div id="footer">
        <Footer />
      </div>
    </>
  );
}

export default Home;

