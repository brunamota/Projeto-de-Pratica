
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import Home from './pages/home';
import Login from './pages/login';
import Cadastros from './pages/cadastros'

const Routes = () => {
  return (
    <BrowserRouter>
    <Switch>
      <Route component={Home} path="/" exact />
      <Route component={Login} path="/login" />
      <Route component={Cadastros} path="/cadastros"/>
    </Switch>
    </BrowserRouter>
  );
}
export default Routes;

