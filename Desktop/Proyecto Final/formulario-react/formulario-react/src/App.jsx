import Formulario from './components/Login'
import './App.css'
import img from './img/EduBusEscolar.png'

function App() {

  return (
    <>
      
      <div className='app-form'>
        <img src={img} alt="Logo aplicacion" className='app-image'/>
        <Formulario/>
      </div>
    </>
  )
}

export default App
