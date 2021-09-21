import foot from '../../../assets/images/Ufj_nome.png'

const Footer = () => {
    return(
        <div className="container">
        <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
          <p className="col-md-4 mb-0 text-muted">© 2021 Jump Cat Co.</p>
      
          <a href="/" className="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
            <img src={foot} alt="UFJ" width="80" />
          </a>
        </footer>
      </div>
    );
}

export default Footer;