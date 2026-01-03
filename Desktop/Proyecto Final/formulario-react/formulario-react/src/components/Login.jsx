import { useState } from "react";

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
        <form onSubmit={validarDatos}>
            <input
                type="text"
                placeholder="Nombre Usuario"
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
            />

            <input
                type="password"
                placeholder="Contraseña"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />

            <button type="submit">Enviar</button>
        </form>
    );
}

export default Formulario;