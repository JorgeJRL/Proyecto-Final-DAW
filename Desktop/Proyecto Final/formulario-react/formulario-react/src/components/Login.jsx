import { useState } from "react";
import '../styles/Login.css'
function Formulario() {
    const [nombre, setNombre] = useState("")
    const [password, setPassword] = useState("")
    //const [error, setError] = useState(false)
   // const [erroMessage, setErrorMessage] = useState("")

    const validarDatos = (e) => {
        e.preventDefault();
        console.log(nombre,password)
    }

     return (
    <div className="login-container">
      <form className="login-form" onSubmit={validarDatos}>
        <h2>Iniciar Sesión</h2>

        <input
          type="text"
          placeholder="Nombre Usuario"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
          className="input"
        />

        <input
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="input"
        />

        <button type="submit" className="btn-login">
          Iniciar
        </button>
      </form>
    </div>
  );
}

export default Formulario;