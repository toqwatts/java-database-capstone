// Import required functions and constants
import { openModal } from './modal.js';
import { BASE_API_URL } from './config.js';

// Define API endpoints
const ADMIN_API = `${BASE_API_URL}/admin/login`;
const DOCTOR_API = `${BASE_API_URL}/doctor/login`;

// Ensure DOM is ready
window.onload = function () {
    const adminLoginBtn = document.getElementById('adminLogin');
    const doctorLoginBtn = document.getElementById('doctorLogin');

    if (adminLoginBtn) {
        adminLoginBtn.addEventListener('click', () => openModal('adminLogin'));
    }

    if (doctorLoginBtn) {
        doctorLoginBtn.addEventListener('click', () => openModal('doctorLogin'));
    }
};

// Admin login handler
window.adminLoginHandler = async function () {
    const username = document.getElementById('adminUsername')?.value.trim();
    const password = document.getElementById('adminPassword')?.value.trim();

    const admin = { username, password };

    try {
        const response = await fetch(ADMIN_API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(admin),
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('token', data.token);
            selectRole('admin');
        } else {
            alert('Invalid admin credentials. Please try again.');
        }
    } catch (error) {
        console.error('Admin login error:', error);
        alert('An error occurred while logging in. Please try again later.');
    }
};

// Doctor login handler
window.doctorLoginHandler = async function () {
    const email = document.getElementById('doctorEmail')?.value.trim();
    const password = document.getElementById('doctorPassword')?.value.trim();

    const doctor = { email, password };

    try {
        const response = await fetch(DOCTOR_API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(doctor),
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('token', data.token);
            selectRole('doctor');
        } else {
            alert('Invalid doctor credentials. Please try again.');
        }
    } catch (error) {
        console.error('Doctor login error:', error);
        alert('An error occurred while logging in. Please try again later.');
    }
};
