import pp_head from '../../../assets/images/pp_DAW.png'

const NavBar = () =>{
    return (
<>        
<header className="py-3 mb-4 border-bottom">
    <div className="container d-flex flex-grow justify-content-center">
      <a  href="/" className="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
      <img src={pp_head} alt="Job Pool" width="130" />
      </a>
    </div>
  </header>
  </>
    );
}

export default NavBar;