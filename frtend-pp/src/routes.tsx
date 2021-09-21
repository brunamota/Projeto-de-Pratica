
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import Home from './pages/home';
import Login from './pages/login';


const Routes = () => {
  return (
    <BrowserRouter>
    <Switch>
      <Route component={Home} path="/" exact />
      <Route component={Login} path="/login" />
    </Switch>
    </BrowserRouter>
  );
}
export default Routes;

