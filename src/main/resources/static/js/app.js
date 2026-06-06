const API_URL = "http://localhost:8080/api/pacientes";
const LOGIN_URL = "http://localhost:8080/auth/login";

let token = "";

document.addEventListener("DOMContentLoaded", function () {

    async function iniciarSesion() {
        const response = await fetch(LOGIN_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username: "Angel", password: "123456789" })
        });
        const data = await response.json();
        token = data.token;
        cargarPacientes();
    }

    async function cargarPacientes() {
        const response = await fetch(API_URL, {
            headers: { "Authorization": "Bearer " + token }
        });
        const pacientes = await response.json();

        const tbody = document.querySelector("tbody");
        tbody.innerHTML = "";

        pacientes.forEach(p => {
            const fila = document.createElement("tr");
            fila.innerHTML = `
                <td>${p.id}</td>
                <td>${p.nombre}</td>
                <td>${p.edad}</td>
                <td>${p.eps}</td>
                <td>${p.telefono}</td>
                <td>${p.correo}</td>
                <td>
                    <button class="btn-eliminar" onclick="eliminarPaciente(${p.id})">Eliminar</button>
                </td>
            `;
            tbody.appendChild(fila);
        });
    }

    document.querySelector(".login-paciente").addEventListener("submit", async function (e) {
        e.preventDefault();

        const edad = parseInt(document.getElementById("inputEdad").value);
        const telefono = document.getElementById("inputTelefono").value;

        if (edad < 0 || edad > 120) {
            alert("La edad debe estar entre 0 y 120 años");
            return;
        }

        if (!/^\d+$/.test(telefono)) {
            alert("El teléfono solo puede contener números");
            return;
        }

        const paciente = {
            nombre: document.getElementById("inputName").value,
            edad: edad,
            eps: document.getElementById("inputEPS").value,
            telefono: telefono,
            correo: document.getElementById("inputEmail").value
        };

        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + token
            },
            body: JSON.stringify(paciente)
        });

        if (response.ok) {
            alert("Paciente registrado exitosamente");
            this.reset();
            cargarPacientes();
        } else {
            alert("Error al registrar el paciente");
        }
    });

    window.eliminarPaciente = async function (id) {
        if (!confirm("¿Seguro que deseas eliminar este paciente?")) return;

        await fetch(API_URL + "/" + id, {
            method: "DELETE",
            headers: { "Authorization": "Bearer " + token }
        });

        cargarPacientes();
    };

    document.getElementById("inputTelefono").addEventListener("input", function () {
        this.value = this.value.replace(/[^0-9]/g, "");
    });

    iniciarSesion();
});